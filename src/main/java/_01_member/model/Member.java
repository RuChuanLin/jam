package _01_member.model;

import java.sql.Clob;

/**
 * @author PC-26
 *
 */
public class Member {

	private int userId;
	private String account;
	private String password;
	private String instrument;
	private boolean isOneClick;
	private String email;
	private boolean isNoted;
	private String alias;
	private String url;
	private String pic;
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
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public boolean isOneClick() {
		return isOneClick;
	}
	public void setOneClick(boolean isOneClick) {
		this.isOneClick = isOneClick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isNoted() {
		return isNoted;
	}
	public void setNoted(boolean isNoted) {
		this.isNoted = isNoted;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Member(int userId, String account, String password, String instrument, boolean isOneClick, String email,
			boolean isNoted, String alias, String url, String pic, String intro) {
		this.userId = userId;
		this.account = account;
		this.password = password;
		this.instrument = instrument;
		this.isOneClick = isOneClick;
		this.email = email;
		this.isNoted = isNoted;
		this.alias = alias;
		this.url = url;
		this.pic = pic;
		this.intro = intro;
	}
	public Member() {
	}
	public Member(String account, String password, String instrument, boolean isOneClick, String email, boolean isNoted,
			String alias, String url, String pic, String intro) {
		this.account = account;
		this.password = password;
		this.instrument = instrument;
		this.isOneClick = isOneClick;
		this.email = email;
		this.isNoted = isNoted;
		this.alias = alias;
		this.url = url;
		this.pic = pic;
		this.intro = intro;
	}
	public Member(int userId) {
		this.userId = userId;
	}
	
	
	
}
