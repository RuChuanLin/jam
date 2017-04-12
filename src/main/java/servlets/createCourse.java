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
import _03_course.model.Course;
import _03_course.model.CourseDAO;
import _03_course.model.CourseHBN;


@WebServlet("/createCourse")
public class createCourse extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("fe");
		JsonObject crsInfo=(JsonObject)new JsonParser().parse(new InputStreamReader(req.getInputStream(),"utf-8"));
		JsonObject ret=new JsonObject();
		System.out.println("create Course");
		req.setCharacterEncoding("UTF-8");
		Member mem=(Member)req.getSession().getAttribute("Member");
		System.out.println(mem);
		if(mem!=null){
		CourseDAO crs=new CourseHBN();
		Course cr=new Course();
		
		System.out.println(crsInfo.toString());
		cr.setArea(crsInfo.get("area").getAsString());
		cr.setCategory(crsInfo.get("cate").getAsString());
		cr.setCharge(crsInfo.get("charge").getAsInt());
		cr.setExpectedStudent(crsInfo.get("audience").getAsString());
		cr.setDuration(crsInfo.get("dur").getAsByte());
		cr.setIntro(crsInfo.get("intro").getAsString());
		cr.setInstruments(crsInfo.get("cate").getAsString());
		cr.setStatus(crsInfo.get("ifOpen").getAsBoolean());
		cr.setExperience(crsInfo.get("experience").getAsByte());
		cr.setTeacherId(mem.getUserId());
		cr.setVideo("sdf");
		crs.saveCourse(cr);
		ret.addProperty("createSuccess",true);
		
		}
		else{
			System.out.println("you are not logged in");
			ret.addProperty("createSuccess", false);
		}
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
		
		
		
		
	}
	
}
