package _02_transaction.model;


public class NewItem {
	private int newItemId;
	private String category;
	private String brand;
	private int price;
	private String title;
	private String model;
	private byte onSale;
	private int itemCount;
	private int sold;
	
	public NewItem(int newItemId, String category, String brand, int price, String title, String model, byte onSale,
			int itemCount, int sold) {
		super();
		this.newItemId = newItemId;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.title = title;
		this.model = model;
		this.onSale = onSale;
		this.itemCount = itemCount;
		this.sold = sold;
	}

	public NewItem() {
		
	}

	
}
