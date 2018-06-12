package model;

import dao.DAOProduct;

public class Order {
	private String id;
	private String cusid;
	private String proid;
	private String date;
	private int quantity;
	private double total;
	public Order(String id, String cusid, String proid, String date, int quantity) {
		super();
		this.id = id;
		this.cusid = cusid;
		this.proid = proid;
		this.date = date;
		this.quantity = quantity;
		this.total = getTotal();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getProid() {
		return proid;
	}
	public void setProid(String proid) {
		this.proid = proid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return DAOProduct.lookUp(this.proid).getProductPrice() * quantity;
	}
	public void setTotal(double total) {
		this.total = total ;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", cusid=" + cusid + ", proid=" + proid + ", date=" + date + ", quantity=" + quantity
				+ ", total=" + total + "]" + "\n";
	}
	
	
}
