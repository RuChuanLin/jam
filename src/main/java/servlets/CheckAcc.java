package servlets;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkAcc")
public class CheckAcc extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.setCharacterEncoding("utf-8");
		JsonObject requestInfo=(JsonObject)new JsonParser().parse(new InputStreamReader(req.getInputStream(),"UTF-8"));
		JsonObject returnInfo=new JsonObject();
		System.out.println("CheckAcc");
                MemberDAO mhn=new MemberHBN();
                Member mem=mhn.getMemberByAccount(requestInfo.get("acc").getAsString());
                resp.setHeader("Access-Contro-Allow-Origin", "*");
                resp.setHeader("Content-Type", "application/json");
                if(mem!=null){
                    returnInfo.addProperty("accExt",true);
                }else{
                    returnInfo.addProperty("accExt",false);
                }
		
		PrintWriter pw=resp.getWriter();
		pw.write(returnInfo.toString());
		pw.close();

	}

}
