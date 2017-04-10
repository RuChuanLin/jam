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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;
import _02_transaction.model.BidRecord;
import _02_transaction.model.UsedItem;
import _02_transaction.model.UsedItemDAO;
import _02_transaction.model.UsedItemHBN;
import _02_transaction.model.UsedItemPic;

@WebServlet("/usedItemDetail")
public class UsedItemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		System.out.println(itemId);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("Member");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsedItemDAO dao = new UsedItemHBN();
		PrintWriter pw = response.getWriter();

		System.out.println(itemId);
		UsedItem ui = dao.getItem(itemId);
		List<UsedItemPic> listUIP = dao.getAllPic(itemId);
		List<String> listPic = new ArrayList<String>();
		for (int i = 0; i < listUIP.size(); i++) {
			listPic.add(listUIP.get(i).getPicBase64());
		}
		String status = "全新";
		switch (ui.getStatus()) {
		case 1:
			status = "像新的一樣";
			break;
		case 2:
			status = "良好";
		case 3:
			status = "外觀微損";
			break;
		case 4:
			status = "部分功能損壞";
			break;
		}
		MemberDAO mDao = new MemberHBN();
		Member mb = mDao.getMember(ui.getSeller());
		String seller = mb.getAlias();
		String sellerPic = mb.getPic();
		List<BidRecord> temp = dao.getBid(itemId);
		List bidderList = new ArrayList<>();
		for (BidRecord br : temp) {
			Map<String, Object> bidMap = new HashMap<>();
			Member mm = mDao.getMember(br.getBidder());
			bidMap.put("userId", br.getBidder());
			bidMap.put("status", br.getStatus());
			bidMap.put("pic", mm.getPic());
			bidMap.put("alias", mm.getAlias());
			bidderList.add(bidMap);
		}

		map.put("usedItem", ui);
		map.put("pics", listPic);
		map.put("status", status);
		map.put("seller", seller);
		map.put("sellerPic", sellerPic);
		map.put("bidderList", bidderList);
		String json = gson.toJson(map);
		pw.write(json);
		pw.flush();
		pw.close();
	}

}
