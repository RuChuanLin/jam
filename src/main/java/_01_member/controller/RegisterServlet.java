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

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(12312333);
		response.setContentType("application/json; charset=UTF-8");
		Map<String, Object> map = new HashMap<>();
		
//		 讀取輸入資料
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.print(account+password);
		Gson gson = new Gson();
		MemberDAO dao = new MemberService();
		PrintWriter pw = response.getWriter();
		
		// 檢查帳號是否輸入及是否已存在
		if (dao.idExists(account)) {
			map.put("regSuccess", false);
			System.out.println("該帳號已存在");
		}
			
		// 有問題
		if (!map.isEmpty()) {
			pw.write(new Gson().toJson(map));
			pw.flush();
			System.out.println("註冊失敗");
			return;
		}
		
		// 沒問題
		Member mb = new Member(account, password, false, account, true, null, null, null);
		dao.saveMember(mb);
		 
		map.put("regSuccess", true);
		pw.write(new Gson().toJson(map));
		pw.flush();
		System.out.println("成功註冊");
		return;

	}
}
