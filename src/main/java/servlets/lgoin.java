package servlets;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class lgoin extends HttpServlet  {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.setCharacterEncoding("UTF-8");
        
        String json=req.getReader().readLine();
        System.out.println(json);
        
		JsonObject loginInfo=new JsonParser().parse(json).getAsJsonObject();
		JsonObject returnInfo=new JsonObject();
                System.out.println(loginInfo.toString());
                String acc=loginInfo.get("acc").getAsString();
                String pwd=loginInfo.get("pw").getAsString();
                
                System.out.println("acc"+acc+"pwd"+pwd);
                resp.addHeader("Access-Control-Allow-Origin","*");
                MemberDAO mhn=new MemberHBN();
                Member mem=null;
                if(loginInfo.get("fbUID")!=null){
                        mem=mhn.getMemberByAccount(acc);
                    }else if(mhn.checkPassword(acc, pwd)){
                        mem=mhn.getMemberByAccount(acc);
                }else{  mem=mhn.getMemberByAccount(acc);}
                
                if(mem==null){
                    returnInfo.addProperty("loginSuccess",false);
                }else{
                    req.getSession(true).setAttribute("Member", mem);
//              前端收到：{"loginSuccess": true/false,"id":String, "alias":String,"pic": base64/String}
                    returnInfo.addProperty("loginSuccess", true);
                    returnInfo.addProperty("id", mem.getUserId());
                    returnInfo.addProperty("alias", mem.getAlias());
                    returnInfo.addProperty("pic",mem.getPic());
                }
                
        resp.setHeader("Content-Type", "multipart/mixed");
		PrintWriter pw=resp.getWriter();
		pw.write(returnInfo.toString());
		pw.close();
	}
	


}


