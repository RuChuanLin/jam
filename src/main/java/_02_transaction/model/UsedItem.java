package _02_transaction.model;

import java.util.Calendar;

public class UsedItem {
	private int usedItemId;
	private String category;
	private String brand;
	private String usedTime;
	private String description;
	private byte status;
	private byte preference;
	private int expectedPrice;
	private String title;
	private String model;
	private int browsedCount;
	private int seller;
	private Calendar updatedDate;
	private byte onSale;


	public int getUsedItemId() {
		return usedItemId;
	}

	public void setUsedItemId(int usedItemId) {
		this.usedItemId = usedItemId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public byte getPreference() {
		return preference;
	}

	public void setPreference(byte preference) {
		this.preference = preference;
	}

	public int getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(int expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getBrowsedCount() {
		return browsedCount;
	}

	public void setBrowsedCount(int browsedCount) {
		this.browsedCount = browsedCount;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public byte getOnSale() {
		return onSale;
	}

	public void setOnSale(byte onSale) {
		this.onSale = onSale;
	}

	
	public UsedItem() {
		super();
	}

	public UsedItem(String category, String brand, String usedTime, String description, 
			byte status, byte preference, int expectedPrice, String title, String model, 
			int browsedCount, int seller, Calendar updatedDate, byte onSale) {
		super();
		this.category = category;
		this.brand = brand;
		this.usedTime = usedTime;
		this.description = description;
		this.status = status;
		this.preference = preference;
		this.expectedPrice = expectedPrice;
		this.title = title;
		this.model = model;
		this.browsedCount = browsedCount;
		this.seller = seller;
		this.updatedDate = updatedDate;
		this.onSale = onSale;
	}

}
