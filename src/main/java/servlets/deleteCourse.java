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


@WebServlet("/deleteCourse")
public class deleteCourse extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control_Allow-Origin","*");
		JsonObject ret;
		Member mem=(Member)req.getSession().getAttribute("Member");
		if(mem!=null){
			ret=doDelete(Integer.parseInt(req.getParameter("courseId")),mem);
		}
		else{
			ret=new JsonObject();
			ret.addProperty("deleteSuccess", false);
		}
		
		
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		JsonObject ret;
		Member mem=(Member)req.getSession().getAttribute("Member");
		if(mem!=null){
			ret=doDelete(Integer.parseInt(req.getParameter("courseId")),mem);
		}
		else{
			ret=new JsonObject();
			ret.addProperty("deleteSuccess", false);
		}
		
		
		PrintWriter pw=resp.getWriter();
		pw.write(ret.toString());
		pw.close();
		
	}
	
	private JsonObject doDelete(int courseId, Member mem){
		JsonObject result=new JsonObject();
		CourseDAO crs=new CourseHBN();
		if(crs.getItem(courseId).getTeacherId()==mem.getUserId()){
			crs.offCourse(courseId);
			result.addProperty("deleteSuccess",true);
		}
		else{result.addProperty("deleteSuccess",false);}

		return result;
		
	}
	
}
