package _02_transaction.model;

import java.util.Calendar;

public class BidRecord {
	private int pk;
	private int itemId;
	private int bidder;
	private int price;
	private int status;
	private Calendar time;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

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

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public BidRecord(int pk) {
		this.pk = pk;
	}

	public BidRecord(int itemId, int bidder, int price, int status, Calendar time) {
		super();
		this.itemId = itemId;
		this.bidder = bidder;
		this.price = price;
		this.status = status;
		this.time = time;
	}

	public BidRecord(int pk, int itemId, int bidder, int price, int status, Calendar time) {
		super();
		this.pk = pk;
		this.itemId = itemId;
		this.bidder = bidder;
		this.price = price;
		this.status = status;
		this.time = time;
	}

	public BidRecord() {
	}

}
