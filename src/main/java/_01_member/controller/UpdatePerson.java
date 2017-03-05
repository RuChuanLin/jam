package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Clob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialClob;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

/**
 * Servlet implementation class UpdatePerson
 */
@WebServlet("/updatePerson")
public class UpdatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String email = request.getParameter("email");
		String alias = request.getParameter("alias");
		String pic = request.getParameter("pic");
		String intro = request.getParameter("intro");
		
		System.out.println(account+email+alias+pic+intro);
		MemberDAO memberDao = new MemberHBN();
		
		Member mem = new Member(account, "", null, true, email, true, alias, pic, intro);
		memberDao.updateMember(mem);
		Member memReturn = new Member("piano", true, email, true, alias, pic, intro);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String json = gson.toJson(mem);
		
		System.out.println(json);
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();

	}

}
