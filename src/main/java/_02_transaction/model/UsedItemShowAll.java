package _02_transaction.model;

import java.util.Calendar;


public class UsedItemShowAll {
	private int usedItemId;
	private String category;
	private String brand;
	private int expectedPrice;
	private String title;
	private String model;
	private int seller;
	private Calendar updatedDate;
	
	
	public UsedItemShowAll() {
		super();
	}


	public UsedItemShowAll(int usedItemId, String category, String brand, int expectedPrice, String title, String model,
			int seller, Calendar updatedDate) {
		super();
		this.usedItemId = usedItemId;
		this.category = category;
		this.brand = brand;
		this.expectedPrice = expectedPrice;
		this.title = title;
		this.model = model;
		this.seller = seller;
		this.updatedDate = updatedDate;
	}
	
	
	
}
