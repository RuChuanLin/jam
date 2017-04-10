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
		String url[] = request.getParameterValues("url[]");
		String urlString = "";
		if (instruments != null) {
			for (int i = 0; i < instruments.length; i++) {
				instru += instruments[i] + " ";
			}
			instru = instru.trim();
		}
		if (url != null) {
			for (int i = 0; i < url.length; i++) {
				urlString += url[i] + " ";
			}
			urlString = urlString.trim();
		}

		if (email.trim() != null && email.trim().length() != 0) {
			mem.setEmail(email);
		}
		if (alias.trim() != null && alias.trim().length() != 0) {
			mem.setAlias(alias);
		}
		if (pic.trim() != null && pic.trim().length() != 0) {
			mem.setPic(pic);
		}
		mem.setIntro(intro);
		mem.setInstrument(instru);
		mem.setUrl(urlString);

		dao.updateMember(mem);
		session.setAttribute("Member", mem);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		// 不回傳密碼
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
