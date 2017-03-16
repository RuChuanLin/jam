package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import _01_member.model.InnerMsg;
import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

@WebServlet("/deletemsg")
public class MessageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		Map<String, Object> map = new HashMap<>();
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		MemberDAO dao = new MemberHBN();
		InnerMsg msg = new InnerMsg();

		String[] msgDelete = request.getParameterValues("msgDelete[]");
		for (int i = 0; i < msgDelete.length; i++) {
			int id = Integer.parseInt(msgDelete[i]);
			msg.setPk(id);
			dao.deleteMsg(msg);
		}
		map.put("delSuccess", true);
		pw.write(gson.toJson(map));
		pw.flush();

	}
}
