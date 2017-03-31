package servlets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import _03_course.model.Course;
import _03_course.model.CourseDAO;
import _03_course.model.CourseHBN;


@WebServlet("/createCourse")
public class createCourse extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject crsInfo=(JsonObject)new JsonParser().parse(new InputStreamReader(req.getInputStream(),"utf-8"));
		String area,cate,audience,intro,instru;
		int userId,charge;
		req.setCharacterEncoding("UTF-8");
		CourseDAO crs=new CourseHBN();
		Course cr=new Course();
		area=crsInfo.get("area").getAsString();
		cate=crsInfo.get("cate").getAsString();
		charge=crsInfo.get("charge").getAsInt();
		audience=crsInfo.get("cate").getAsString();
		cate=crsInfo.get("cate").getAsString();
		intro=crsInfo.get("intro").getAsString();
		userId=crsInfo.get("userId").getAsInt();
		
		
		//public Course(int teacherId, String category, String instruments, String area, String expectedArea, byte duration,
			//	byte experience, int charge, String expectedStudent, String video, String intro, Calendar updatetime, boolean status) 
		
		
		
		
	}
	
}
