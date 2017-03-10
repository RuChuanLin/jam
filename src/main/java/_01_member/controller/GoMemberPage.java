package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class GoMemberPage
 */
@WebServlet("/goMemberPage")
public class GoMemberPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		int memberId = Integer.parseInt(request.getParameter("memberId").toString());
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		
		PrintWriter pw= response.getWriter();
		MemberDAO dao = new MemberHBN();
		Member mb = dao.getMember(memberId);
		map.put("Member", mb);
		session.setAttribute("Member", mb);
		String json = gson.toJson(map);
		pw.write(json);
		pw.flush();
		pw.close();
		
		
		
		
		
		
	}

}
