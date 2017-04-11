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
	private String intro;
	public int getNewItemId() {
		return newItemId;
	}
	public void setNewItemId(int newItemId) {
		this.newItemId = newItemId;
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
	public byte getOnSale() {
		return onSale;
	}
	public void setOnSale(byte onSale) {
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
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public NewItem() {
	}
	
	public NewItem(String category, String brand, int price, String title, String model, byte onSale,
			int itemCount, int sold, String intro) {
		this.newItemId = newItemId;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.title = title;
		this.model = model;
		this.onSale = onSale;
		this.itemCount = itemCount;
		this.sold = sold;
		this.intro = intro;
	}
	
	

	
}
