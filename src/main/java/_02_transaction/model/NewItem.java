package _02_transaction.model;

import java.sql.Blob;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class NewItem {
	private int usedItemId;
	private String category;
	private String brand;
	private java.sql.Blob image;
	private int price;
	private String title;
	private String model;
	private int browsedCount;
	private java.util.Calendar updatedDate;
	private char onSale;
	private int itemCount;
	private int sold;

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

	public java.sql.Blob getImage() {
		return image;
	}

	public void setImage(java.sql.Blob image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public java.util.Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(java.util.Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public char getOnSale() {
		return onSale;
	}

	public void setOnSale(char onSale) {
		this.onSale = onSale;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public NewItem(String category, String brand, Blob image, int price, String title, String model, int browsedCount,
			Calendar updatedDate, char onSale, int itemCount, int sold) {
		super();
		this.category = category;
		this.brand = brand;
		this.image = image;
		this.price = price;
		this.title = title;
		this.model = model;
		this.browsedCount = browsedCount;
		this.updatedDate = updatedDate;
		this.onSale = onSale;
		this.itemCount = itemCount;
		this.sold = sold;
	}

	public NewItem(int usedItemId) {
		super();
		this.usedItemId = usedItemId;
	}

	public NewItem() {
		super();
	}

	public NewItem(int usedItemId, String category, String brand, Blob image, int price, String title, String model,
			int browsedCount, Calendar updatedDate, char onSale, int itemCount, int sold) {
		super();
		this.usedItemId = usedItemId;
		this.category = category;
		this.brand = brand;
		this.image = image;
		this.price = price;
		this.title = title;
		this.model = model;
		this.browsedCount = browsedCount;
		this.updatedDate = updatedDate;
		this.onSale = onSale;
		this.itemCount = itemCount;
		this.sold = sold;
	}
}
