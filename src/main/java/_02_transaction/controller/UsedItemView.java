package _02_transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import _01_member.model.Member;
import _02_transaction.model.UsedItem;
import _02_transaction.model.UsedItemDAO;
import _02_transaction.model.UsedItemHBN;
import _02_transaction.model.UsedItemPic;

/**
 * Servlet implementation class UsedItemView
 */
@WebServlet("/usedItemView")
public class UsedItemView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("Member");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsedItemDAO dao = new UsedItemHBN();
		PrintWriter pw = response.getWriter();
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("currentPage: " + currentPage);
		}
		long[] page = dao.getAllpage("");
		int totalPages = (int) page[1];
		System.out.println("totalPages: " + totalPages);
		System.out.println("currentPage: " + currentPage);
		List<UsedItem> list = dao.getAllItem("", currentPage);
		List listWithPic = new ArrayList<>();
		for (UsedItem ui : list) {
			String pic = dao.getFirstPic(ui.getUsedItemId());
			List temp = new ArrayList<>();
			temp.add(ui);
			temp.add(pic);
			listWithPic.add(temp);
			// listWithPic.
		}
		if (currentPage < totalPages) {
			currentPage++;
			listWithPic.add(currentPage);
		} else {
			currentPage = -1;
			listWithPic.add(-1);
		}
		String json = gson.toJson(listWithPic);
		pw.write(json);
		pw.flush();
		pw.close();
	}
}
