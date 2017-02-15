package _02_transaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderItem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int PK;
	private int orderNo;
	private int newItemId;
	private int number;

	public int getPK() {
		return PK;
	}

	public void setPK(int pK) {
		PK = pK;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getNewItemId() {
		return newItemId;
	}

	public void setNewItemId(int newItemId) {
		this.newItemId = newItemId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "OrderItem [orderNo=" + orderNo + ", newItemId=" + newItemId + ", number=" + number + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public OrderItem(int orderNo, int newItemId, int number) {
		this.orderNo = orderNo;
		this.newItemId = newItemId;
		this.number = number;
	}

	public OrderItem() {
	}

	public OrderItem(int pK, int orderNo, int newItemId, int number) {
		super();
		PK = pK;
		this.orderNo = orderNo;
		this.newItemId = newItemId;
		this.number = number;
	}
}
