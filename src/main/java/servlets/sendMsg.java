package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _01_member.model.InnerMsg;
import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;


@WebServlet("/sendMsg")
public class sendMsg extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
                JsonObject reqInfo=new JsonParser().parse(req.getReader()).getAsJsonObject();
                resp.setHeader("Access-Contro-Allow-Origin", "*");
                JsonObject ret=new JsonObject();
                MemberDAO mhn=new MemberHBN();
                int succ=-1;
                
                HttpSession ses=req.getSession(false);
                //	public InnerMsg(int sender, String senderAlias, int receiver, String title, String article, Calendar time,boolean state) {
                InnerMsg msg=new InnerMsg();
                
                if(ses!=null){
                    Member mem=(Member)ses.getAttribute("Member");
                    msg.setArticle(reqInfo.get("article").getAsString());
                    msg.setSender(mem.getUserId());
                    msg.setTitle(reqInfo.get("title").getAsString());
                    msg.setReceiver(reqInfo.get("receiver").getAsInt());
                    msg.setSenderAlias(mem.getAlias());
                    msg.setState(false);
                    msg.setTime(Calendar.getInstance());
                    succ=mhn.setMsg(msg);
                }
                if(succ==0){ret.addProperty("sent",false);}else{ret.addProperty("sent",true);}
                
                
                PrintWriter pw=resp.getWriter();
                pw.write(ret.toString());
                pw.close();
	}

}
