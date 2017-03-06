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
import _01_member.model.MemberService;

@WebServlet("/_01_member/controller/memberData.do")
public class MemberData extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberService();
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		
		String account = session.getAttribute("LoginAcc").toString();
		Map<String, Object> map = new HashMap<>();
		
		Member mb = dao.getMemberByAccount(account);
		map.put("pic", mb.getPic());
		map.put("alias", mb.getAlias());
//		map.put("instrument",);
		map.put("intro", mb.getIntro());
//		map.put("mediaLink",);
		
		pw.println(new Gson().toJson(map));
		pw.flush();
		System.out.println("成功登入");
		return;
	}

}
