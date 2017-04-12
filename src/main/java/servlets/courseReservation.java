package servlets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;

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
import _03_course.model.ReserveRecord;


@WebServlet("/courseReservation")
public class courseReservation extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject crsInfo=(JsonObject)new JsonParser().parse(new InputStreamReader(req.getInputStream(),"utf-8"));
		JsonObject ret=new JsonObject();
		resp.setHeader("Access-Control_Allow-Origin","*");
		req.setCharacterEncoding("UTF-8");
		int courseId=crsInfo.get("courseId").getAsInt();
		CourseDAO crs=new CourseHBN();
		ReserveRecord rsr=new ReserveRecord();
		rsr.setPk(courseId);
		rsr.setTime(Calendar.getInstance());
		rsr.setStudentId(1);
		rsr.setStatus((byte)1);
		rsr.setTeacherId(courseId);
		crs.newBid(rsr);
		ret.addProperty("reserved", true);
		
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
		
		
		
		
	}
	
}
