package model;

public class LineItem {
	private Product product;
	private int quantity;
	public LineItem() {
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return product.getProductPrice() * quantity;
	}
	@Override
	public String toString() {
		return "LineItem [product=" + product + ", quantity=" + quantity + "]";
	}
	
}
