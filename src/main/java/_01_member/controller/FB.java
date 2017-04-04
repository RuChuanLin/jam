package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

/**
 * Servlet implementation class FB
 */
@WebServlet("/FB")
public class FB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String alias = request.getParameter("alias");
		String pic = request.getParameter("pic");
		System.out.println(account+' '+alias+' '+pic);
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		MemberDAO dao = new MemberHBN();
		PrintWriter pw = response.getWriter();
		Member mb = null;
		// 如果此人FB沒有設定email...
		if (account == null) {

		}

		// 如果帳號不存在表示沒註冊過, 進行註冊 PS:這個方法名稱應該改名為isExists()...XD
		if (!dao.idExists(account)) {
			System.out.println("FB帳號不存在，進行註冊");
			mb = new Member(account, null, null, false, account, true, alias, pic, null, null);
			dao.saveMember(mb);
			//本行是為了因應下面需要取得ID
			mb = dao.getMemberByAccount(account);
		} else {
			System.out.println("FB帳號存在，進行登入");
			// 存在表示已經註冊，可以從DB撈資料
			mb = dao.getMemberByAccount(account);
		}
		map.put("loginSuccess", true);
		map.put("alias", alias);
		map.put("loginId", mb.getUserId());
		map.put("pic", mb.getPic());
		String json = new Gson().toJson(map);
		System.out.println(json);
		pw.write(json);
		System.out.println("mb.getAlias(): " + mb.getAlias());
		System.out.println("mb.getUserId(): " + mb.getUserId());
		System.out.println(mb);
		pw.flush();
		System.out.println("成功登入");
		session.setAttribute("Member", mb);
		return;

	}

}
