package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Arrays;
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
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<>();
		Member sessionMb = (Member) session.getAttribute("Member");
		String account = session.getAttribute("LoginAcc").toString();
		System.out.println("account: " + account);
		String email = request.getParameter("email");
		String alias = request.getParameter("alias");
		String pic = request.getParameter("pic");
		String intro = request.getParameter("intro");
		String instruments[] = request.getParameterValues("instruments[]");
		String url_arr[] = request.getParameterValues("url_arr[]");

		String instru = "";
		System.out.println(account);
		if (instruments != null) {
			for (int i = 0; i < instruments.length; i++) {
				instru += instruments[i] + " ";
			}
		}
		instru = instru.trim();
		String url = "";
		if (url_arr != null && url_arr.length != 0) {
			for (int i = 0; i < url_arr.length; i++) {
				url += url_arr[i] + " ";
			}
		}
		url = url.trim();
		MemberDAO memberDao = new MemberHBN();
		Member mem = new Member(account, "", instru, true, email, true, alias, url, pic, intro);
		memberDao.updateMember(mem);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		session.setAttribute("Member", mem);
		map.put("Member", mem);
		String json = gson.toJson(map);
		System.out.println(json);
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();

	}

}
