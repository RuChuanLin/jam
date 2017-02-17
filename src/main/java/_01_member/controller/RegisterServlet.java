package _01_member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/_01_member/controller/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 錯誤和成功訊息的 Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
        request.setAttribute("signupErrorMsg", errorMsg);  
        Map<String, String> successMsg = new HashMap<String, String>();
        request.setAttribute("successMsg", successMsg);
		// 讀取輸入資料
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		// 檢查輸入資料
		if (account == null || account.trim().length() == 0) {
			errorMsg.put("errorAccount", "*帳號欄必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.put("errorPassword", "*密碼欄必須輸入");
		}
		if (passwordCheck == null || passwordCheck.trim().length() == 0) {
			errorMsg.put("errorPasswordCheck", "*請驗證密碼");
		}
		if (passwordCheck.trim().length() != 0 && !passwordCheck.equals(password)) {
			errorMsg.put("errorPasswordCheck", "*與密碼輸入不同");
		}
	
//		RegisterService rs = new RegisterService();
//		if (account.trim().length() != 0 && rs.idExists(account)) {
//			errorMsg.put("accountExist", "*該帳號 已經存在");
//		}
		// 有問題回原頁面
		if (!errorMsg.isEmpty()) {
			errorMsg.put("userAccount", account);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		}
		// 沒問題到成功頁面
//		try {
//			RegisterMemberBean mem = new RegisterMemberBean(account, password);
//			rs.saveRegisterMember(mem);
//			successMsg.put("userAccount", account);
//			successMsg.put("Success", "，您已成功註冊");
//			RequestDispatcher rd = request.getRequestDispatcher("register/success.jsp");
//			rd.forward(request, response);
//			return;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
