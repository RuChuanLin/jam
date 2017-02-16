package _05_forum.model;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;


public class Forum {
	private int columnId;
	private String title ;
	private String author ;
	private java.sql.Date date ;
	private String tag;
	private java.sql.Clob article;
	private java.sql.Blob image;
	
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public java.sql.Clob getArticle() {
		return article;
	}
	public void setArticle(java.sql.Clob article) {
		this.article = article;
	}
	public java.sql.Blob getImage() {
		return image;
	}
	public void setImage(java.sql.Blob image) {
		this.image = image;
	}
	public Forum(String title, String author, Date date, String tag, Clob article, Blob image) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.tag = tag;
		this.article = article;
		this.image = image;
	}
	public Forum(int columnId) {
		this.columnId = columnId;
	}
	public Forum() {
	}
	public Forum(int columnId, String title, String author, Date date, String tag, Clob article, Blob image) {
		this.columnId = columnId;
		this.title = title;
		this.author = author;
		this.date = date;
		this.tag = tag;
		this.article = article;
		this.image = image;
	}
}
