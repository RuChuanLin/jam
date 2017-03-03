package _03_course.model;

import java.util.Calendar;


public class ReserveRecord {
	private int pk;
	private int teacherId;
	private int studentId;
	private java.util.Calendar time;
	private byte status;
	public ReserveRecord(int pk) {
		this.pk = pk;
	}
	public ReserveRecord(int teacherId, int studentId, Calendar time, byte status) {
		this.teacherId = teacherId;
		this.studentId = studentId;
		this.time = time;
		this.status = status;
	}
	public ReserveRecord() {
	}
	public ReserveRecord(int pk, int teacherId, int studentId, Calendar time, byte status) {
		this.pk = pk;
		this.teacherId = teacherId;
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public java.util.Calendar getTime() {
		return time;
	}
	public void setTime(java.util.Calendar time) {
		this.time = time;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
}
