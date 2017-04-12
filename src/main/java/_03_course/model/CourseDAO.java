package _03_course.model;

import java.util.List;

public interface CourseDAO {
	//新增開課資料
	public int saveCourse(Course co);
	//獲得搜尋後的總頁數和資料數(不知道要搜啥key值給)
	
	public long[] getAllpage(String key);
	//獲得搜尋後的該頁全部資料(不搜尋則key值給"")
	public List<Course> getAllItem(String key,int page);
	//獲得老師帳號&暱稱&圖片
	public String[] getTeacher(int teacherId);
	//獲得該筆的所有資料
	public Course getItem(int courseId);
	//修改開課資料
	public int updateCourse(Course co);
	//關閉開課資訊
	public int offCourse(int courseId);
	
	//新增預約紀錄
	public int newBid(ReserveRecord rr);
	//獲得預約紀錄
	public List<ReserveRecord> getBid(int courseId);
}
