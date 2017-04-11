package _02_transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import _01_member.model.Member;
import _02_transaction.model.BidRecord;
import _02_transaction.model.UsedItemDAO;
import _02_transaction.model.UsedItemHBN;

@WebServlet("/newBid")
public class NewBid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("Member");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsedItemDAO dao = new UsedItemHBN();
		PrintWriter pw = response.getWriter();
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		boolean bidded = Boolean.parseBoolean(request.getParameter("bidded"));
		Calendar time = Calendar.getInstance();
		BidRecord br = new BidRecord(itemId, mem.getUserId(), 0, 1, time);
		String json = "";
		int n = 0;
		if (!bidded) {
			n = dao.newBid(br);
			json = gson.toJson(n);
		} else {
			n = dao.cancelBid(itemId, mem.getUserId());
			json = gson.toJson(n);
		}

		pw.write(json);
		pw.flush();
		pw.close();

	}

}
