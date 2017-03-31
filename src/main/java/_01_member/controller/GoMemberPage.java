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

@WebServlet("/goMemberPage")
public class GoMemberPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<>();
		PrintWriter pw = response.getWriter();
		MemberDAO dao = new MemberHBN();
		Gson gson = new Gson();
		String json = "";
		Member mb = (Member) session.getAttribute("Member");
		String member = request.getParameter("member");
		boolean myself = false;
		int id;

		if (member == null) {
			id = 0;
		} else {
			id = Integer.parseInt(request.getParameter("member"));
		}
		System.out.println(id);

		if (id != 0 && id != mb.getUserId()) {
			mb = dao.getMember(id);
			myself = true;
		}
		mb.setPassword("");
		map.put("Member", mb);
		map.put("myself", myself);
		pw.write(gson.toJson(map));
	}

}
