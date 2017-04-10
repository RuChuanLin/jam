package _02_transaction.model;

import java.util.Calendar;
public class OrderForm {
	private int orderId;
	private String name;
	private String phone;
	private String address;
	private short zip;
	private int buyer;
	private java.util.Calendar buyTime;
	private int amount;
	public OrderForm(int orderId, String name, String phone, String address, short zip, int buyer, Calendar buyTime,
			int amount) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.buyer = buyer;
		this.buyTime = buyTime;
		this.amount = amount;
	}
	public OrderForm() {
		super();
	}
	public OrderForm(int orderId) {
		super();
		this.orderId = orderId;
	}
	public OrderForm(String name, String phone, String address, short zip, int buyer, Calendar buyTime, int amount) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.buyer = buyer;
		this.buyTime = buyTime;
		this.amount = amount;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public short getZip() {
		return zip;
	}
	public void setZip(short zip) {
		this.zip = zip;
	}
	public int getBuyer() {
		return buyer;
	}
	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}
	public java.util.Calendar getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(java.util.Calendar buyTime) {
		this.buyTime = buyTime;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}	

}