package _02_transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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

@WebServlet("/usedItemPublish")
public class UsedItemPublish extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("this is from get");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("Member");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsedItemDAO dao = new UsedItemHBN();
		PrintWriter pw = response.getWriter();
		String item = request.getParameter("itemId");
		if (item != null && item.trim().length() != 0) {
			int itemId = Integer.parseInt(item);
			UsedItem ui = dao.getItem(itemId);
			List<UsedItemPic> listUIP = dao.getAllPic(itemId);
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < listUIP.size(); i++) {
				list.add(listUIP.get(i).getPicBase64());
			}

			List listWithPic = new ArrayList<>();

			listWithPic.add(ui);
			listWithPic.add(list);

			String json = gson.toJson(listWithPic);

			pw.write(json);
		}
		pw.flush();
		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("this is from POST");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("Member");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsedItemDAO dao = new UsedItemHBN();
		PrintWriter pw = response.getWriter();
		String itemId_string = request.getParameter("itemId");
		int itemId = -1;
		// 品牌
		String brand = request.getParameter("brand");
		// 型號
		String model = request.getParameter("model");
		// 狀態
		byte status = Byte.parseByte(request.getParameter("status"));
		// 使用年份
		String usedTime = request.getParameter("usedTime");
		// 標題
		String title = request.getParameter("title");
		// 價錢
		int expectedPrice = Integer.parseInt(request.getParameter("expectedPrice"));
		// 交易方式
		// byte preference = Byte.parseByte(request.getParameter("preference"));
		byte preference = 0;
		// 樂器品項
		String category = request.getParameter("category");
		// 描述
		String description = request.getParameter("description");
		// 賣家ID
		int seller = mem.getUserId();
		// 上架日期
		Calendar updatedDate = Calendar.getInstance();

		if (itemId_string.trim().equals("")) {
			// 沒有物品ID，代表使用者正在PO新物品
			// 透過搜尋該用戶最後一筆新增的資料來取得剛剛新增的itemId
			UsedItem uim = new UsedItem(category, brand, usedTime, description, status, preference, expectedPrice,
					title, model, 0, seller, updatedDate, (byte) 0);
			dao.saveItem(uim);
			itemId = dao.getNewId(seller);
			// 獲得圖片+存入
			String pic_arr[] = request.getParameterValues("pic_arr[]");
			for (int i = 0; i < pic_arr.length; i++) {
				if (pic_arr[i].trim().length() != 0) {
					UsedItemPic uip = new UsedItemPic(itemId, pic_arr[i]);
					dao.savePic(uip);
				}
			}
		} else {
			// 有物品ID，代表使用者正在修改物品
			itemId = Integer.parseInt(itemId_string);
			UsedItem uim = new UsedItem(itemId, category, brand, usedTime, description, status, preference,
					expectedPrice, title, model, 0, seller, updatedDate, (byte) 0);
			dao.updateItem(uim);
			String pic_arr[] = request.getParameterValues("pic_arr[]");
			dao.updatePic(itemId, pic_arr);
			// for (int i = 0; i < pic_arr.length; i++) {
			// if (pic_arr[i].trim().length() != 0) {
			// UsedItemPic uip = new UsedItemPic(itemId, i + 1, pic_arr[i]);
			// dao.updatePic(itemId, uip);
			// }
			// }
		}

		// 回傳成功
		map.put("Sucess", "true");
		pw.write(gson.toJson(map));
	}

}
