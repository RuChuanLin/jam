package _02_transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _02_transaction.model.NewItem;
import _02_transaction.model.NewItemDAO;
import _02_transaction.model.NewItemHBN;





/**
 * Servlet implementation class UsedItemView
 */
@WebServlet("/newItemView")
public class NewItemView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		NewItemDAO dao = new NewItemHBN();
		PrintWriter pw = response.getWriter();
		System.out.println("request.getParameter category: " + request.getParameter("category"));
		String category = request.getParameter("category") == null ? "" : request.getParameter("category");
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("currentPage: " + currentPage);
		}
		long[] page = dao.getAllpage(category);
		int totalPages = (int) page[1];
		System.out.println("totalPages: " + totalPages);
		System.out.println("currentPage: " + currentPage);

		List<NewItem> list = dao.getAllItem(category, currentPage);

		List listWithPic = new ArrayList<>();
		for (NewItem ni : list) {
			System.out.println("ui.getPrice(): " + ni.getPrice());
			String pic = dao.getFirstPic(ni.getNewItemId());
			List temp = new ArrayList<>();
			temp.add(ni);
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
