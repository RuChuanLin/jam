package _999_test.tx.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _999_test.tx.model.TX;
import _999_test.tx.model.TXDAO;
import _999_test.tx.model.TXObject;

/**
 * Servlet implementation class TXServlet
 */
@WebServlet("/_999_test/tx/controller/TXServlet.do")
public class TXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		int number = Integer.parseInt(request.getParameter("number"));
		long longNumber = Long.parseLong(request.getParameter("longNumber"));
		TXObject txo = new TXObject(account, password, number, longNumber);
		TX tx = new TXDAO();
		tx.saveObject(txo);
	}

}
