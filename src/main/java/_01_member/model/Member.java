package _01_member.model;

import java.sql.Blob;

public class Member {

	private int userId;
	private String account;
	private String password;
	private boolean isOneClick;
	private String email;
	private boolean isNoted;
	private String alias;
	private Blob pic;
	private String intro;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsOneClick() {
		return isOneClick;
	}

	public void setIsOneClick(boolean isOneClick) {
		this.isOneClick = isOneClick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsNoted() {
		return isNoted;
	}

	public void setIsNoted(boolean isNoted) {
		this.isNoted = isNoted;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Blob getPic() {
		return pic;
	}

	public void setPic(Blob pic) {
		this.pic = pic;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Member() {
		super();
	}
	
	//註冊時用的
	public Member(String account, String password, boolean isOneClick, String email, boolean isNoted, String alias,
			Blob pic, String intro) {
		super();
		this.account = account;
		this.password = password;
		this.isOneClick = isOneClick;
		this.email = email;
		this.isNoted = isNoted;
		this.alias = alias;
		this.pic = pic;
		this.intro = intro;
	}
	
	public Member(int userId, String account, String password, boolean isOneClick, String email, boolean isNoted,
			String alias, Blob pic, String intro) {
		super();
		this.userId = userId;
		this.account = account;
		this.password = password;
		this.isOneClick = isOneClick;
		this.email = email;
		this.isNoted = isNoted;
		this.alias = alias;
		this.pic = pic;
		this.intro = intro;
	}
}
