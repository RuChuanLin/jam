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

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;
import _02_transaction.model.BidRecord;
import _02_transaction.model.UsedItemDAO;
import _02_transaction.model.UsedItemHBN;

/**
 * Servlet implementation class ConfirmBid
 */
@WebServlet("/confirmBid")
public class ConfirmBid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		UsedItemDAO dao = new UsedItemHBN();
		PrintWriter pw = response.getWriter();
		String bidder_str = request.getParameter("bidder");
		int bidder = -1;
		if (bidder_str != null) {
			bidder = Integer.parseInt(bidder_str);
		}
		int decision = Integer.parseInt(request.getParameter("decision"));
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		if (decision == 1) {
			// 賣家確認買家
			dao.setBidStatus(itemId, -1);
			dao.confirmBid(itemId, bidder);
		} else if (decision == -1) {
			// 賣家反悔，取消確認買家
			dao.setBidStatus(itemId, 1);
		} else if (decision == -2) {
			System.out.println("decision == -2:" + itemId + " " + bidder);
			dao.cancelBid(itemId, bidder);
		}
		MemberDAO mDao = new MemberHBN();
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
		map.put("bidderList", bidderList);
		String json = gson.toJson(map);
		pw.write(json);
		pw.flush();
		pw.close();
	}

}
