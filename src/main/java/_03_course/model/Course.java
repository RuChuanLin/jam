package _03_course.model;

import java.util.Calendar;

public class Course {
	private int courseId;
	private int teacherId;
	private String category;
	private String instruments;
	private String area;
	private String expectedArea;
	private byte duration;
	private byte experience;
	private int charge;
	private String expectedStudent;
	private String video;
	private String intro;
	private Calendar updatetime;
	//開課狀態 1是顯示開課  0是不顯示
	private boolean status;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInstruments() {
		return instruments;
	}

	public void setInstruments(String instruments) {
		this.instruments = instruments;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExpectedArea() {
		return expectedArea;
	}

	public void setExpectedArea(String expectedArea) {
		this.expectedArea = expectedArea;
	}

	public byte getDuration() {
		return duration;
	}

	public void setDuration(byte duration) {
		this.duration = duration;
	}

	public byte getExperience() {
		return experience;
	}

	public void setExperience(byte experience) {
		this.experience = experience;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public String getExpectedStudent() {
		return expectedStudent;
	}

	public void setExpectedStudent(String expectedStudent) {
		this.expectedStudent = expectedStudent;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Calendar getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Calendar updatetime) {
		this.updatetime = updatetime;
	}

	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Course(int teacherId, String category, String instruments, String area, String expectedArea, byte duration,
			byte experience, int charge, String expectedStudent, String video, String intro, Calendar updatetime, boolean status) {
		super();
		this.teacherId = teacherId;
		this.category = category;
		this.instruments = instruments;
		this.area = area;
		this.expectedArea = expectedArea;
		this.duration = duration;
		this.experience = experience;
		this.charge = charge;
		this.expectedStudent = expectedStudent;
		this.video = video;
		this.intro = intro;
		this.updatetime = updatetime;
		this.status = status;
	}

	public Course() {
		super();
	}

	public Course(int courseId, int teacherId, String category, String instruments, String area, String expectedArea,
			byte duration, byte experience, int charge, String expectedStudent, String video, String intro,
			Calendar updatetime,boolean status) {
		super();
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.category = category;
		this.instruments = instruments;
		this.area = area;
		this.expectedArea = expectedArea;
		this.duration = duration;
		this.experience = experience;
		this.charge = charge;
		this.expectedStudent = expectedStudent;
		this.video = video;
		this.intro = intro;
		this.updatetime = updatetime;
		this.status = status;
	}

}
