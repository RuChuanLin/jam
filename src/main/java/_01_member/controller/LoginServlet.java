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
import _01_member.model.MemberService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		MemberDAO dao = new MemberService();
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		
		// 檢查帳號是否輸入及是否存在
		if (!dao.idExists(account)) {
			map.put("loginSuccess", false);
			System.out.println("帳號不存在");
		}
		
		// 檢查密碼是否輸入及是否正確
		if (!dao.checkPassword(account, password)) {
			map.put("loginSuccess", false);
			System.out.println("密碼錯誤");
		}

		//有問題
		if (!map.isEmpty()) {
			pw.write(new Gson().toJson(map));
			pw.flush();
			System.out.println("登入失敗");
			return;
		}
		
		//沒問題
		Member mb = dao.getMemberByAccount(account);
		int id = mb.getUserId();
		map.put("regSuccess", true);
		map.put("userId", id);
		map.put("nickName", mb.getAlias());
//		map.put("messageNum",);
		pw.write(new Gson().toJson(map));
		pw.flush();
		System.out.println("成功登入");
		session.setAttribute("LoginId", id);
		session.setAttribute("LoginAcc", account);
		return;
	}

}
