package _01_member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		MemberDAO dao = new MemberHBN();
		PrintWriter pw = response.getWriter();
		String account = null;
		String password = null;
		String pic = null;
		String alias = null;
		// 讀取輸入資料
		// boolean isOneClick =
		// Boolean.parseBoolean(request.getParameter("isOneClick"));

		// if (isOneClick) {
		// account = request.getParameter("account");
		// pic = request.getParameter("pic");
		// alias = request.getParameter("alias");
		//
		// } else {
		account = request.getParameter("account");
		password = request.getParameter("password");

		alias = account.split("@")[0];
		System.out.println(account +"/"+ password);

		// 檢查帳號是否輸入及是否已存在
		if (dao.idExists(account)) {
			map.put("regSuccess", false);
			System.out.println("該帳號已存在");
		}

		// 有問題
		if (!map.isEmpty()) {
			pw.write(new Gson().toJson(map));
			pw.flush();
			System.out.println("註冊失敗");
			return;
		}

		// 沒問題
		ServletContext context = getServletContext();
		URL url = context.getResource("/images/pic.png");
		File file = new File(url.getFile());
		System.out.println(file);
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];
		is.read(bytes, 0, bytes.length);
		is.close();
		byte[] picb64 = Base64.encodeBase64(bytes);
		pic = "data:image/png;base64," + new String(picb64);
		// }

		Member mb = new Member(account, password, null, false, account, true, alias, pic, null, null);
		dao.saveMember(mb);

		map.put("regSuccess", true);
		pw.write(new Gson().toJson(map));
		pw.flush();
		System.out.println("成功註冊");

		// RequestDispatcher rd = request.getRequestDispatcher("/login.do");
		// rd.forward(request, response);

		return;

	}
}
