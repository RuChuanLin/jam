package _03_course.model;

import java.sql.Blob;
import java.sql.Date;


public class Course {
	private int courseId;
	private int teacherId;
	private String category;
	private String expectedArea;
	private byte duration;
	private byte experience;
	private int charge;
	private String expectedStudent;
	private int video;
	private java.sql.Blob picture;
	private String intro;
	private java.sql.Date time;

	public Course(int courseId, int teacherId, String category, String expectedArea, byte duration, byte experience,
			int charge, String expectedStudent, int video, Blob picture, String intro, Date time) {
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.category = category;
		this.expectedArea = expectedArea;
		this.duration = duration;
		this.experience = experience;
		this.charge = charge;
		this.expectedStudent = expectedStudent;
		this.video = video;
		this.picture = picture;
		this.intro = intro;
		this.time = time;
	}

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

	public int getVideo() {
		return video;
	}

	public void setVideo(int video) {
		this.video = video;
	}

	public java.sql.Blob getPicture() {
		return picture;
	}

	public void setPicture(java.sql.Blob picture) {
		this.picture = picture;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public java.sql.Date getTime() {
		return time;
	}

	public void setTime(java.sql.Date time) {
		this.time = time;
	}

	public Course(int courseId) {
		this.courseId = courseId;
	}

	public Course(int teacherId, String category, String expectedArea, byte duration, byte experience, int charge,
			String expectedStudent, int video, Blob picture, String intro, Date time) {
		this.teacherId = teacherId;
		this.category = category;
		this.expectedArea = expectedArea;
		this.duration = duration;
		this.experience = experience;
		this.charge = charge;
		this.expectedStudent = expectedStudent;
		this.video = video;
		this.picture = picture;
		this.intro = intro;
		this.time = time;
	}

	public Course() {
	}
}
