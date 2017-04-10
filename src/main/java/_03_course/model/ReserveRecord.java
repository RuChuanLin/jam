package _03_course.model;

import java.util.Calendar;


public class ReserveRecord {
	private int pk;
	private int courseId;
	private int studentId;
	private Calendar time;
	private byte status;
	public ReserveRecord(int pk) {
		this.pk = pk;
	}
	public ReserveRecord(int courseId, int studentId, Calendar time, byte status) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.time = time;
		this.status = status;
	}
	public ReserveRecord() {
	}
	public ReserveRecord(int pk, int courseId, int studentId, Calendar time, byte status) {
		this.pk = pk;
		this.courseId = courseId;
		this.studentId = studentId;
		this.time = time;
		this.status = status;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Calendar getTime() {
		return time;
	}
	public void setTime(Calendar time) {
		this.time = time;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
}
