package _999_test.tx.model;

public class TXObject {
	private long pk;
	private String account;
	private String password;
	private int number;
	private long longNumber;
	public long getPk() {
		return pk;
	}
	public void setPk(long pk) {
		this.pk = pk;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public long getLongNumber() {
		return longNumber;
	}
	public void setLongNumber(long longNumber) {
		this.longNumber = longNumber;
	}
	public TXObject(long pk) {
		this.pk = pk;
	}
	public TXObject() {
	}
	public TXObject(String account, String password, int number, long longNumber) {
		this.account = account;
		this.password = password;
		this.number = number;
		this.longNumber = longNumber;
	}
	public TXObject(long pk, String account, String password, int number, long longNumber) {
		this.pk = pk;
		this.account = account;
		this.password = password;
		this.number = number;
		this.longNumber = longNumber;
	}
}
