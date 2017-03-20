package _01_member.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Clob;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

@WebServlet("/login")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberHBN();
		PrintWriter pw = response.getWriter();
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();

		String fbId = request.getParameter("fbId");
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		// 檢查帳號是否輸入及是否存在
		if (fbId == null) {
			if (!dao.idExists(account)) {
				map.put("loginSuccess", false);
				System.out.println("帳號不存在");
			} else if (!dao.checkPassword(account, password)) {
				map.put("loginSuccess", false);
				System.out.println("密碼錯誤");
			}
		}

		// 有問題
		if (!map.isEmpty()) {
			pw.write(new Gson().toJson(map));
			pw.flush();
			System.out.println("登入失敗");
			return;
		}

		// 沒問題
		Member mb = dao.getMemberByAccount(account);
		String encoded = mb.getPic().split(",")[1];
		ByteArrayInputStream bais = new ByteArrayInputStream(Base64.decodeBase64(encoded));
		BufferedImage prevImage = ImageIO.read(bais); 
		int type = prevImage.getType();
		int size =22;
		String format ="";
		if (type == BufferedImage.TYPE_4BYTE_ABGR || type == BufferedImage.TYPE_4BYTE_ABGR_PRE
				|| type == BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_ARGB_PRE) {
			format = "png";
		} else {
			format = "jpg";
		}
	    BufferedImage image = new BufferedImage(size, size, type);  
	    Graphics graphics = image.createGraphics();  
	    graphics.drawImage(prevImage, 0, 0, size, size, null);  
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(image, format, baos);
	    byte[] smallPic = baos.toByteArray();
	    byte[] picb64 = Base64.encodeBase64(smallPic);
		String pic = "data:image/"+format+";base64," + new String(picb64);
		
		bais.close();
		
		map.put("loginSuccess", true);
		map.put("alias", mb.getAlias());
		map.put("loginId", mb.getUserId());
		map.put("pic", pic);
		String json = new Gson().toJson(map);
		System.out.println(json);
		pw.write(json);
		System.out.println("mb.getAlias(): " + mb.getAlias());
		System.out.println(mb);
		pw.flush();
		System.out.println("成功登入");
		session.setAttribute("Member", mb);
		return;
		
		
		
	}

}
