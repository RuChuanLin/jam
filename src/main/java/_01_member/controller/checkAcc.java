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

import com.google.gson.Gson;

import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

@WebServlet("/checkAcc")
public class checkAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		Map<String, Object> map = new HashMap<>();

		// 讀取輸入資料
		String account = request.getParameter("account");

		System.out.println(account);
		Gson gson = new Gson();
		MemberDAO dao = new MemberHBN();
		PrintWriter pw = response.getWriter();

		
		map.put("accExt", dao.idExists(account));
		System.out.println("該帳號已存在");

		pw.write(new Gson().toJson(map));
		pw.flush();
		System.out.println("註冊");
		return;

	}
}
