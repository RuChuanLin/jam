package _02_transaction.model;

import java.util.Calendar;
public class BidRecord {
	private int pk;
	private int itemId;
	private int bidder;
	private int price;
	private java.util.Calendar time;
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getBidder() {
		return bidder;
	}
	public void setBidder(int bidder) {
		this.bidder = bidder;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public java.util.Calendar getTime() {
		return time;
	}
	public void setTime(java.util.Calendar time) {
		this.time = time;
	}
	
	public BidRecord(int pk) {
		this.pk = pk;
	}
	public BidRecord(int itemId, int bidder, int price, Calendar time) {
		super();
		this.itemId = itemId;
		this.bidder = bidder;
		this.price = price;
		this.time = time;
	}
	public BidRecord() {
	}
	public BidRecord(int pk, int itemId, int bidder, int price, Calendar time) {
		super();
		this.pk = pk;
		this.itemId = itemId;
		this.bidder = bidder;
		this.price = price;
		this.time = time;
	}
}
