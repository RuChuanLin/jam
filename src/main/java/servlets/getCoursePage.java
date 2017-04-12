package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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


@WebServlet("/getCoursePage")
public class getCoursePage extends HttpServlet {
	
	private static String tutor_self="/tutor_detail_self.html";
	private static String tutor="/tutor_detail.html";
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control_Allow-Origin","*");
		resp.addHeader("Content-Type", "multipart/mixed");
		int crsId=Integer.parseInt(req.getParameter("crsId"));
		CourseDAO crs=new CourseHBN();
		Course cr=crs.getItem(crsId);
		Member mem=(Member)req.getSession().getAttribute("Member");
		if(mem!=null &&mem.getUserId()==cr.getCourseId()){
			System.out.println("is my self");
			this.getServletContext().getRequestDispatcher(tutor).forward(req, resp);
		}else{
			this.getServletContext().getRequestDispatcher(tutor_self).forward(req, resp);
		}



	}

	
	
	
	
}
