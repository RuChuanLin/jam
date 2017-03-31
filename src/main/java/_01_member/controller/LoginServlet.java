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

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
		map.put("loginSuccess", true);
		map.put("alias", mb.getAlias());
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
