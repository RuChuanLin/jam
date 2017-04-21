package _02_transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _00_init.PicSize;
import _02_transaction.model.UsedItem;
import _02_transaction.model.UsedItemDAO;
import _02_transaction.model.UsedItemHBN;

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
		Gson gson = new Gson();
		UsedItemDAO dao = new UsedItemHBN();
		PrintWriter pw = response.getWriter();
		System.out.println("request.getParameter category: " + request.getParameter("category"));
		String category = request.getParameter("category") == null ? "" : request.getParameter("category");
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("================");
			System.out.println("currentPage: " + currentPage);
		}

		long[] page = dao.getAllpage(category);
		int totalPages = (int) page[1];
		// System.out.println("totalPages: " + totalPages);
		// System.out.println("currentPage: " + currentPage);
		if (currentPage <= totalPages) {
			List<UsedItem> list = dao.getAllItem(category, currentPage);

			List listWithPic = new ArrayList<>();
			for (UsedItem ui : list) {
				// System.out.println("ui.getExpectedPrice(): " +
				// ui.getExpectedPrice());
				String pic = dao.getFirstPic(ui.getUsedItemId());
				List temp = new ArrayList<>();
				// pic = PicSize.minify(pic, 220);
				temp.add(ui);
				temp.add(pic);
				listWithPic.add(temp);
			}

			currentPage++;
			listWithPic.add(currentPage);
			String json = gson.toJson(listWithPic);
			pw.write(json);
			pw.flush();
			pw.close();
		}

	}
}
