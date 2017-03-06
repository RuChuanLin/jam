package _01_member.model;

import java.sql.Clob;
import java.util.Calendar;
public class InnerMsg {
	private int pk;
	private int sender;
	private int receiver;
	private String title;
	private java.sql.Clob article;
	private java.util.Calendar time;
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public java.sql.Clob getArticle() {
		return article;
	}
	public void setArticle(java.sql.Clob article) {
		this.article = article;
	}
	public java.util.Calendar getTime() {
		return time;
	}
	public void setTime(java.util.Calendar time) {
		this.time = time;
	}
	public InnerMsg(int sender, int receiver, String title, Clob article, Calendar time) {
		this.sender = sender;
		this.receiver = receiver;
		this.title = title;
		this.article = article;
		this.time = time;
	}
	public InnerMsg(int pk) {
		this.pk = pk;
	}
	public InnerMsg() {
	}
	public InnerMsg(int pk, int sender, int receiver, String title, Clob article, Calendar time) {
		this.pk = pk;
		this.sender = sender;
		this.receiver = receiver;
		this.title = title;
		this.article = article;
		this.time = time;
	}
}
