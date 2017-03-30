package servlets;

import _01_member.model.InnerMsg;
import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/msgbox")
public class messageBox extends HttpServlet {
	private static final String TYPE_NEWMSG="newMsg";
	private static final String TYPE_GETMSG="getMsg";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject msgReq=new JsonParser().parse(req.getReader()).getAsJsonObject();
		JsonObject result;
		HttpSession ses=req.getSession(false);
                resp.setHeader("Access-Control-Allow-Origin", "*");
                InnerMsg imsg=new InnerMsg();
                Member mem=(Member)req.getSession(false).getAttribute("Member");
		if(ses!=null){
		switch(msgReq.get("servType").getAsString()){
			case TYPE_NEWMSG:
				result=countNewMessage(msgReq,mem);
				break;
			case TYPE_GETMSG:
				result=getMessage(msgReq,mem);
				break;
			default:
                                    result=onMsgFailed(-2);
				break;
				}
			}else{result=onMsgFailed(-3);}
		
		PrintWriter pw=resp.getWriter();
		pw.write(result.toString());
		pw.close();
	}
        
        private JsonObject countNewMessage(JsonObject info,Member mem){
            MemberDAO mhn=new MemberHBN();
            JsonObject ret=new JsonObject();
            int u=mhn.newMsg(mem.getUserId());
            if(u==0){
                ret.addProperty("result",-1);
                }else{
                ret.addProperty("result",u);
            }
            return ret;
        }
        
        
        private JsonObject getMessage(JsonObject info,Member mem){
            MemberDAO mhn=new MemberHBN();
           JsonObject ret =new JsonObject();
           JsonArray msgArr=new JsonArray();
           List<InnerMsg> messages;
           int startId=info.get("rngStart").getAsInt();
           if(startId!=-1){
            messages=mhn.getMsg(mem.getUserId(), 1000);
           }else{
            messages=mhn.getMsg(mem.getUserId(), startId);
           }
           
           InnerMsg[] msgs=new InnerMsg[messages.size()];
           messages.toArray(msgs);
           int smallest=msgs[0].getPk();
           for(int u=0;u<msgs.length;u++){
               JsonObject tmp=new JsonObject();
               tmp.addProperty("pk", msgs[u].getPk());
               tmp.addProperty("sender", msgs[u].getSender());
               tmp.addProperty("senderAlias", msgs[u].getSenderAlias());
               tmp.addProperty("title", msgs[u].getTitle());
               tmp.addProperty("time", msgs[u].getTime().toString());
               tmp.addProperty("article", msgs[u].getArticle());
               tmp.addProperty("state", msgs[u].getState());
               msgArr.add(tmp);
               if(u>=10){
                   break;
               }
               
           }
               ret.addProperty("result", msgs.length);
               ret.add("msgs",msgArr);
        
        return ret;
        }
        
        
        
        private JsonObject onMsgFailed(int code){
            JsonObject report=new JsonObject();
            report.addProperty("result",code);
            return report;
        }
	
}
