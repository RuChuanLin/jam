package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

@WebServlet("/msgRead")
public class MessageRead extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		MemberDAO dao = new MemberHBN();
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		boolean unread = false;
		
		int id = Integer.parseInt(request.getParameter("msgId"));
		dao.changeState(id);
		
		unread = true;
		pw.write(gson.toJson(unread));
		
	}
}
