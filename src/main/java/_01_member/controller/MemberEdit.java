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

@WebServlet("/memberEdit")
public class MemberEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();

		Member mb = (Member) session.getAttribute("Member");
		System.out.println(mb.getAccount());
		System.out.println(mb.getPassword());

		session.setAttribute("Member", mb);
		// 不回傳密碼
		mb.setPassword("");
		map.put("Member", mb);
		String json = gson.toJson(map);
		pw.write(json);

	}

}
