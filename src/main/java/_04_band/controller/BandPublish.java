package _04_band.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import _01_member.model.Member;
import _04_band.model.BandDAO;
import _04_band.model.BandHBN;


public class BandPublish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("Member");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		BandDAO dao = new BandHBN();
		PrintWriter pw = response.getWriter();
		
		//發文者
		int author = mem.getUserId();
		//標題主旨
		String title = request.getParameter("title");
		//樂手樂器分類
		String category = request.getParameter("category");
		//具體樂器填寫
		String instruments = request.getParameter("instruments");
		// 樂團地點
		String area = request.getParameter("area");
		// 詳細地點
		String detailedArea = request.getParameter("detailedArea");
		//曲風
		String style = request.getParameter("style");
		//是否已組團
		byte isGrouped = Byte.parseByte(request.getParameter("isGrouped"));
		//團員的帳號名
		String mateLink = request.getParameter("mateLink");
		//影音
		String video = request.getParameter("video");
		//自我推薦文案
		String description = request.getParameter("description");
		//封面
		String image = request.getParameter("image");
		//刊登時間
		Calendar updatetime = Calendar.getInstance();
		
		
		
	}
	
	
}
