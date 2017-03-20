package _01_member.model;

import java.util.Calendar;

public class InnerMsg {
	private int pk;
	private int sender;
	private String senderAlias;
	private int receiver;
	private String title;
	private String article;
	private Calendar time;
	private boolean state;
	
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

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public InnerMsg(int sender, String senderAlias, int receiver, String title, String article, Calendar time,
			boolean state) {
		this.sender = sender;
		this.senderAlias = senderAlias;
		this.receiver = receiver;
		this.title = title;
		this.article = article;
		this.time = time;
		this.state = state;
	}

	public InnerMsg(int pk) {
		this.pk = pk;
	}

	public InnerMsg() {
	}

	public InnerMsg(int pk, int sender, String senderAlias, int receiver, String title, String article, Calendar time,
			boolean state) {
		this.pk = pk;
		this.sender = sender;
		this.senderAlias = senderAlias;
		this.receiver = receiver;
		this.title = title;
		this.article = article;
		this.time = time;
		this.state = state;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getSenderAlias() {
		return senderAlias;
	}

	public void setSenderAlias(String senderAlias) {
		this.senderAlias = senderAlias;
	}

}
