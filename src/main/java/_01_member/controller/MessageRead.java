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

@WebServlet("/msgRead")
public class MessageRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<>();
		Member mem = (Member) session.getAttribute("Member");
		MemberDAO dao = new MemberHBN();
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();

		int id = Integer.parseInt(request.getParameter("msgId"));
		if (id != -1) {
			dao.changeState(id);
		}
		int unreadMsgNumber = dao.newMsg(mem.getUserId());
		System.out.println("userId:  " + mem.getUserId());
		System.out.println("unreadMsgNumber:  " + unreadMsgNumber);
		map.put("unread", true);
		map.put("unreadMsgNumber", unreadMsgNumber);
		pw.write(gson.toJson(map));

	}
}
