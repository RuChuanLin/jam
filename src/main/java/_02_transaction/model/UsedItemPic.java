package _02_transaction.model;

public class UsedItemPic {
	private int picId;
	private int itemId;
	private String picBase64;
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getPicBase64() {
		return picBase64;
	}
	public void setPicBase64(String picBase64) {
		this.picBase64 = picBase64;
	}
	
	public UsedItemPic(int itemId, String picBase64) {
		super();
		this.itemId = itemId;
		this.picBase64 = picBase64;
	}
	public UsedItemPic() {
		super();
	}
	
	
	
	
	
	
}
