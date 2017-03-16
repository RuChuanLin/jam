package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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

@WebServlet("/messageBox")
public class MessageBox extends HttpServlet {
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
		int start = 0;

		String servType = request.getParameter("servType");
		String rngStart = request.getParameter("rngStart");
		if (rngStart != null) {
			start = Integer.parseInt(rngStart);
		}
		
		int userId = mem.getUserId();
		int result = 0;
		// int userId = Integer.parseInt(request.getParameter("userId"));

		if (servType.equals("newMsg")) {
			result = dao.newMsg(userId);
			pw.write(gson.toJson(result));
			pw.flush();
			System.out.println("未讀信件數" + result);
			return;
		} else if (servType.equals("getMsg")) {
			List<InnerMsg> msgs = null;
			result = dao.allMsg(userId);
			if (start == -1) {
				start = Integer.MAX_VALUE;
				msgs = dao.getMsg(userId, start);
				if (msgs.size() > 10)
					msgs.remove(10);
			} else {
				msgs = dao.getMsg(userId, start);
				msgs.remove(0);
			}
			map.put("result", 0);
			map.put("msgs", msgs);
			pw.write(gson.toJson(msgs));
			pw.flush();
			System.out.println("讀取站內信");
			return;

		}

	}
}
