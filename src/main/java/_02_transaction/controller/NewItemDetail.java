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
import _02_transaction.model.NewItemPic;


@WebServlet("/newItemDetail")
public class NewItemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		System.out.println(itemId);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		NewItemDAO dao = new NewItemHBN();
		PrintWriter pw = response.getWriter();

		System.out.println(itemId);
		NewItem ni = dao.getItem(itemId);
		List<NewItemPic> listUIP = dao.getAllPic(itemId);
		List<String> listPic = new ArrayList<String>();
		for (int i = 0; i < listUIP.size(); i++) {
			listPic.add(listUIP.get(i).getPicBase64());
		}
		
		map.put("NewItem", ni);
		map.put("pics", listPic);
		String json = gson.toJson(map);
		pw.write(json);
		pw.flush();
		pw.close();
	}

}
