package servlets;

import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;
import _01_member.model.Member;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		JsonObject regInfo=new JsonParser().parse(req.getReader()).getAsJsonObject();
		JsonObject rst=new JsonObject();
                String acc=regInfo.get("acc").getAsString();
                String pwd=regInfo.get("pw").getAsString();
                MemberDAO mhn=new MemberHBN();
                _01_member.model.Member mem=null;
                System.out.println("register");
                resp.setHeader("Access-Contro-Allow-Origin", "*");
                resp.setHeader("Content-Type", "application/json");
                if(regInfo.get("fbUID")!=null){
                    if(!mhn.idExists(acc)){
                        mem= new Member(acc, null, true);
                        mhn.saveMember(mem);
                    }
	                	}else if(!mhn.idExists(acc)){
	                    mem= new Member(acc, pwd, false);
	                    mhn.saveMember(mem);
	                	}
                    if(mem!=null){
                        rst.addProperty("regSuccess",true);
                    }else{
                    	rst.addProperty("regSuccess",false);
                    }
                    
			PrintWriter pw=resp.getWriter();
			pw.write(rst.toString());
			pw.close();
		}

}
