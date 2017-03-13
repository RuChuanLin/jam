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
 * Servlet implementation class LoadingMember
 */
// 快要不會用到了
@WebServlet("/loadingMember")
public class LoadingMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("LoginId"));
		MemberDAO dao = new MemberHBN();
		Gson gson = new Gson();
		String json = "";
		if (session.getAttribute("Member") != null) {
			Member mb = (Member) session.getAttribute("Member");
			map.put("Member", mb);
			json = gson.toJson(map);
			System.out.println("json: " + json);
		} else {
			Member mb = dao.getMember(id);
			mb.setPassword("");
			map.put("Member", mb);
			session.setAttribute("Member", map);
			json = gson.toJson(map);
		}
		pw.write(json);
	}

}
