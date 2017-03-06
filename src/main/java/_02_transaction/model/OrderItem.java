package _02_transaction.model;



public class OrderItem {
	private int PK;
	private int newItemId;
	private int number;
	private OrderForm orderform;
	public OrderItem(int pK, int newItemId, int number, OrderForm orderform) {
		super();
		PK = pK;
		this.newItemId = newItemId;
		this.number = number;
		this.orderform = orderform;
	}
	public OrderItem() {
		super();
	}
	public OrderItem(int pK) {
		super();
		PK = pK;
	}
	public OrderItem(int newItemId, int number, OrderForm orderform) {
		super();
		this.newItemId = newItemId;
		this.number = number;
		this.orderform = orderform;
	}

}