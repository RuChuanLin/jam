package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import _03_course.model.Course;
import _03_course.model.CourseDAO;
import _03_course.model.CourseHBN;

public class queryCourses extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		CourseDAO crs=new CourseHBN();
		List<Course> cList=crs.getAllItem("", 0);
		
		
		
		
		
	}
	
	
	private JsonArray asJsonArray(Course[] cr){
		JsonObject tmp;
		for(int i=0;i<cr.length;i++){
			cr[i].getArea();
			
		}
		
		return new JsonArray();
	}
	
	

}
