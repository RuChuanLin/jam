package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _01_member.model.InnerMsg;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;

@WebServlet("/deleteMsg")
public class deleteMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=UTF-8");
		JsonObject delReq=new JsonParser().parse(req.getReader()).getAsJsonObject();
		JsonObject res=new JsonObject();
		PrintWriter pw = resp.getWriter();
		
		MemberDAO dao = new MemberHBN();
		InnerMsg msg = new InnerMsg();
		JsonArray msgDel= delReq.getAsJsonArray("msgDelete");
		for(int s=0;s<msgDel.size();s++){
			msg.setPk(msgDel.get(s).getAsInt());
			if(dao.deleteMsg(msg)!=1){
				res.addProperty("prolem", msg.getPk());
			};
			
			}
		
		
		
		res.addProperty("delSuccess", true);
		pw.write(res.toString());
		pw.flush();

	}
}
