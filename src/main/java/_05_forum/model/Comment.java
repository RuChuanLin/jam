package _05_forum.model;

import java.sql.Clob;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int articleId;
	private int author;
	private java.sql.Clob article;
	private java.util.Calendar time;
	private int good;
	private int bad;
	private int responseId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
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
	public int getGood() {
		return good;
	}
	public void setGood(int like) {
		this.good = like;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int dislike) {
		this.bad = dislike;
	}
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	
	public Comment(int articleId, int author, Clob article, Calendar time, int like, int dislike, int responseId) {
		super();
		this.articleId = articleId;
		this.author = author;
		this.article = article;
		this.time = time;
		this.good = like;
		this.bad = dislike;
		this.responseId = responseId;
	}
	public Comment(int id, int articleId, int author, Clob article, Calendar time, int like, int dislike,
			int responseId) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.author = author;
		this.article = article;
		this.time = time;
		this.good = like;
		this.bad = dislike;
		this.responseId = responseId;
	}
	public Comment(int id) {
		super();
		this.id = id;
	}
	public Comment() {
		super();
	}
}
