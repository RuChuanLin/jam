package _01_member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _01_member.model.InnerMsg;
import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

@WebServlet("/sendMsg")
public class MessageSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("Member");
		PrintWriter pw = response.getWriter();
		
		Gson gson = new Gson();

		boolean sent = false;
		
//		int sender = mem.getUserId();
//		String alias = mem.getAlias();
		int sender = 1;//Integer.parseInt(request.getParameter("sender"));
		String alias = request.getParameter("alias");
		int receiver = 2;
		String title = request.getParameter("title");
		String msg = request.getParameter("msg");
		System.out.println(title+msg+" "+receiver);
		
		Calendar time = Calendar.getInstance();
//		MemberDAO dao = new MemberHBN();
//		InnerMsg imsg = new InnerMsg(sender, alias, receiver, title, msg, time, false);
//		dao.setMsg(imsg);
//		
		sent = true ;
		pw.write(gson.toJson(sent));
		pw.flush();

	}

}
