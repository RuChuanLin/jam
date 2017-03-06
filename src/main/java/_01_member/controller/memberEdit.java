package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialClob;

import com.google.gson.Gson;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberService;

@WebServlet("/_01_member/controller/memberEdit.do")
public class MemberEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberService();
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		
		String account = session.getAttribute("LoginAcc").toString();
		String pic = request.getParameter("pic");
		String alias = request.getParameter("alias");
		String intro = request.getParameter("intro");
		Clob pic_clob = null;
		Clob intro_clob = null;
		Map<String, Object> map = new HashMap<>();
		
		try {
			pic_clob = new SerialClob(pic.toCharArray());
			intro_clob = new SerialClob(intro.toCharArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Member mb = dao.getMemberByAccount(account);
		mb.setPic(pic_clob);
		mb.setAlias(alias);
		mb.setIntro(intro_clob);
		dao.updateMember(mb);

		map.put("UpdataSuccess", true);
		pw.println(new Gson().toJson(map));
		pw.flush();
		System.out.println("成功修改");
		return;
	}

}
