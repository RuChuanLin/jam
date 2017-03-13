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

@WebServlet("MessageBox")
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

		String servType = request.getParameter("servType");
		int rngStart = Integer.parseInt(request.getParameter("rngStart"));
//		int userId = mem.getUserId();
		int userId = Integer.parseInt(request.getParameter("userId"));

		if (servType.equals("newMsg")) {
			long result = 0;
			result = dao.newMsg(userId);
			pw.write(gson.toJson(result));
			pw.flush();
			System.out.println("未讀信件數"+result);
			return;
		}

		if (servType.equals("getMsg")) {
			List<InnerMsg> msgs = null;
			if (rngStart == -1) {
				rngStart=Integer.MAX_VALUE;
				msgs = dao.getMsg(userId, rngStart);
				if(msgs.size()>10)
					msgs.remove(10);
			}else {
				msgs = dao.getMsg(userId, rngStart);
				msgs.remove(0);
			}
			pw.write(gson.toJson(msgs));
			pw.flush();
			System.out.println("讀取站內信");
			return;

		}

	}
}
