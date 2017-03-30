package _03_course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

//import _00_init.ReadDATA;
import _01_member.model.Member;
import _03_course.model.Course;
import _03_course.model.CourseDAO;
import _03_course.model.CourseHBN;

@WebServlet("/CoursePublish")
public class CoursePublish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("Member");
		Map<String, Object> map = new HashMap<>();
		Gson gson = new Gson();
		CourseDAO dao = new CourseHBN();
		PrintWriter pw = response.getWriter();

		// 開課id 新增時會接不到 更改資料時才會收到
		String courseId = request.getParameter("courseId");
		// 開課種類
		String category = request.getParameter("category");
		// 具體樂器
		String instruments = request.getParameter("instruments");
		// 教學地區
		String area = request.getParameter("area");
		// 詳細地區
		String expectedArea = request.getParameter("expectedArea");
		// 教學經驗
		byte experience = Byte.parseByte(request.getParameter("experience"));
		// 願意試教時間
		byte duration = Byte.parseByte(request.getParameter("duration"));
		// 收費標準
		int charge = Integer.parseInt(request.getParameter("charge"));
		// 教學對象
		String expectedStudent = request.getParameter("expectedStudent");
		// 影片
		String video = request.getParameter("vedio");
		// 教學文案
		String intro = request.getParameter("intro");
		// 老師ID & 暱稱
		// int teacherId = mem.getUserId();
		// 因為沒登入時存session所以先用下面假裝一下
		int teacherId = 2;
		// 上架日期
		Calendar updatetime = Calendar.getInstance();
		// 是否要刊登   (暫時沒這欄 跟是否下架狀態一樣的意思
		boolean status = Boolean.parseBoolean(request.getParameter("status"));

		if (courseId == null) {
			// 新增商品
			Course co = new Course(teacherId, category, instruments, area, expectedArea, duration, experience,
					charge, expectedStudent, video, intro, updatetime, true);
			dao.saveCourse(co);
		}else {
			Course co = new Course(Integer.parseInt(courseId), teacherId, category, instruments, area, expectedArea, duration, experience,
					charge, expectedStudent, video, intro, updatetime, true);
			dao.updateCourse(co);
		}

		// 回傳成功
		map.put("Sucess", "true");
		pw.write(gson.toJson(map));
	}

}
