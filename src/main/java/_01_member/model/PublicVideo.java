package _01_member.model;


public class PublicVideo {
	private int pk;
	private int userId;
	private String link;
	public PublicVideo(int userId, String link) {
		super();
		this.userId = userId;
		this.link = link;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public PublicVideo(int pk) {
		super();
		this.pk = pk;
	}
	public PublicVideo() {
		super();
	}
	public PublicVideo(int pk, int userId, String link) {
		super();
		this.pk = pk;
		this.userId = userId;
		this.link = link;
	}
}
