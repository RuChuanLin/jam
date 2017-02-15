package _01_member.model;

import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column(name="account", length=70)
	@Size(max=70)
	private String account;
	private String password;
	private boolean isOneClick;
	private String email;
	private boolean isNoted;
	private String alias;
	private java.sql.Blob pic;
	private java.sql.Clob intro;

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

	public java.sql.Blob getPic() {
		return pic;
	}

	public void setPic(java.sql.Blob pic) {
		this.pic = pic;
	}

	public java.sql.Clob getIntro() {
		return intro;
	}

	public void setIntro(java.sql.Clob intro) {
		this.intro = intro;
	}

	public Member() {
		super();
	}

	public Member(String account, String password, boolean isOneClick, String email, boolean isNoted, String alias,
			Blob pic, Clob intro) {
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
			String alias, Blob pic, Clob intro) {
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
