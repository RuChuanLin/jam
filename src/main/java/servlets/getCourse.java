package servlets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _01_member.model.Member;
import _01_member.model.MemberDAO;
import _01_member.model.MemberHBN;
import _03_course.model.Course;
import _03_course.model.CourseDAO;
import _03_course.model.CourseHBN;


@WebServlet("/getCourse")
public class getCourse extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject crsInfo=(JsonObject)new JsonParser().parse(new InputStreamReader(req.getInputStream(),"utf-8"));
		JsonObject ret=new JsonObject();
		resp.setHeader("Access-Control_Allow-Origin","*");
		req.setCharacterEncoding("UTF-8");
		int courseId=crsInfo.get("courseId").getAsInt();
		CourseDAO crs=new CourseHBN();
		MemberDAO mhn=new MemberHBN();
		Member mem;
		Course cr=new Course();
		cr=crs.getItem(courseId);
		mem=new MemberHBN().getMember(cr.getTeacherId());
		ret.addProperty("pic",mem.getPic());
		ret.addProperty("area", cr.getArea());
		ret.addProperty("cate",cr.getCategory());
		ret.addProperty("charge",cr.getCharge());
		ret.addProperty("author",cr.getTeacherId());
		ret.addProperty("audience", cr.getExpectedStudent());
		ret.addProperty("userAlias", mem.getAlias());
		ret.addProperty("courseId",cr.getCourseId());
		ret.addProperty("instrument", cr.getInstruments());
		ret.addProperty("experience", cr.getExperience());
		ret.addProperty("intro", cr.getIntro());
		ret.addProperty("dur",cr.getDuration());
		ret.addProperty("vids",cr.getVideo());
		
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
		
		
		
		
	}
	
}
