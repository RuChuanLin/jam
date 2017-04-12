package servlets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _01_member.model.Member;
import _01_member.model.MemberHBN;
import _03_course.model.Course;
import _03_course.model.CourseHBN;


@WebServlet("/queryCourse")
public class queryCourse extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject crsInfo=(JsonObject)new JsonParser().parse(new InputStreamReader(req.getInputStream(),"utf-8"));
		JsonObject ret;
		resp.addHeader("Access-Control-Allow-Origin","*");
		System.out.println("aaa");
		req.setCharacterEncoding("UTF-8");
		String ser=crsInfo.get("search").getAsString();
		if(ser.equals("noSearch")){
			ret=queryWithoutSearch(crsInfo.get("page").getAsInt());
		}else{
			ret=queryWithSearch(ser,crsInfo.get("page").getAsInt());
		}
		
		
		
		resp.setHeader("Content-Type", "application/json ; multipart/mixed ");
						
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
		
		
		
		
	}
	private JsonObject queryWithoutSearch(int page){
		return queryWithSearch("",page);
	}
	
	private JsonObject queryWithSearch(String search,int page){
		JsonObject ret=new JsonObject();
		JsonArray course=new JsonArray();
		List<Course> courses=new CourseHBN().getAllItem(search, page);
		for(Course cr : courses){
			JsonObject tmp=new JsonObject();
			Member mem=new MemberHBN().getMember(cr.getTeacherId());
			tmp.addProperty("pic",mem.getPic());
			tmp.addProperty("area", cr.getArea());
			tmp.addProperty("cate",cr.getCategory());
			tmp.addProperty("crsId",cr.getCourseId());
			tmp.addProperty("userAlias", mem.getAlias());			
			course.add(tmp);
		}
		
		ret.add("crs", course);
		ret.addProperty("page", page+1);
		return ret;
	}
	

	
}
