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
import com.google.gson.JsonObject;

//import _00_init.ReadDATA;
import _01_member.model.Member;
import _02_transaction.model.UsedItem;
import _02_transaction.model.UsedItemDAO;
import _02_transaction.model.UsedItemHBN;
import _02_transaction.model.UsedItemPic;

@WebServlet("/usedItemUpdate")
public class UsedItemUpdate extends HttpServlet {

	@Override
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
		
		// 物品ID
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		// 取得該物品原資料
		UsedItem uim = dao.getItem(itemId);
		// 品牌
		String brand = request.getParameter("brand");
		uim.setBrand(brand);
		// 型號
		String model = request.getParameter("model");
		uim.setModel(model);
		// 狀態
		byte status = Byte.parseByte(request.getParameter("status"));
		uim.setStatus(status);
		// 使用年份
		String usedTime = request.getParameter("usedTime");
		uim.setUsedTime(usedTime);
		// 標題
		String title = request.getParameter("title");
		uim.setTitle(title);
		// 價錢
		int expectedPrice = Integer.parseInt(request.getParameter("expectedPrice"));
		uim.setExpectedPrice(expectedPrice);
		// 交易方式
		byte preference = Byte.parseByte(request.getParameter("preference"));
		uim.setPreference(preference);
		// 樂器品項
		String category = request.getParameter("category");
		uim.setCategory(category);
		// 描述
		String description = request.getParameter("description");
		uim.setDescription(description);
		
		// 獲得圖片+修改
		String[] pic =new String[5];
		for (int i = 1; i <= 5; i++) {
			pic[i] = request.getParameter("pic" + i );
		}
		
		dao.updateItem(uim);
		dao.updatePic(itemId,pic);

		// 回傳成功
		map.put("Sucess", "true");
		pw.write(gson.toJson(map));
	}

}
