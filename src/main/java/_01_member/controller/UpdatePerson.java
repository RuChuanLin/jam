package _01_member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Clob;
import java.sql.SQLException;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<>();
		Member mem = (Member) session.getAttribute("Member");
		MemberDAO dao = new MemberHBN();
		String account = mem.getAccount();
				
		System.out.println("account: " + account);
		
		String email = request.getParameter("email");
		String alias = request.getParameter("alias");
		String pic = request.getParameter("pic");
		String intro = request.getParameter("intro");
		String instruments[] = request.getParameterValues("instruments[]");
		String instru = "";
		String videoLink[] = request.getParameterValues("video[]");
		String video = "";
		if (instruments != null) {
			for (int i = 0; i < instruments.length; i++) {
				instru += instruments[i] + " \\ ";
			}
			instru = instru.substring(0, instru.length() - 3);
		}
		if (videoLink != null) {
			for (int i = 0; i < videoLink.length; i++) {
				video += videoLink[i] + " \\ ";
			}
			video = video.substring(0, video.length() - 3);
		}
				
		if(email.trim()!= null && email.trim().length()!=0){
			mem.setEmail(email);
		}
		if(alias.trim()!= null && alias.trim().length()!=0){
			mem.setAlias(alias);
		}
		if(pic.trim()!= null && pic.trim().length()!=0){
			mem.setPic(pic);
		}
		mem.setIntro(intro);
		mem.setInstrument(instru);
				
		dao.updateMember(mem);
		session.setAttribute("Member", mem);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		//因安全性的原因而不回傳密碼
		mem.setPassword("");
		map.put("Member", mem);
		String json = gson.toJson(map);
		System.out.println(json);
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();

	}

}
