package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<LineItem> items;

	public Cart() {
		this.items = new ArrayList<LineItem>();
	}
	public List<LineItem> getItems() {
		return items;
	}
	
	public int getCount() {
		return items.size();
	}
	public LineItem lookUp(String productCode) {
		for (LineItem lineItem : items) {
			if (lineItem.getProduct().getProductCode().equals(productCode)) {
				return lineItem;
			}
		}
		return null;
	}
	public void addItem(LineItem item) {
		String id = item.getProduct().getProductCode();
		int quantity = 0;
		for (int i = 0; i < items.size(); i++) {
			LineItem lineItem = items.get(i);
			 quantity = this.getItems().get(i).getQuantity();
			if (lineItem.getProduct().getProductCode().equals(id)) {
				quantity += 1;
				lineItem.setQuantity(quantity);
				return;
			}
		}
		items.add(item);
	}
	
	public void removeItem(LineItem item) {
		String id = item.getProduct().getProductCode();
		int quantity = item.getQuantity();
		for (LineItem lineItem : items) {
			if (lineItem.getProduct().getProductCode().equals(id)) {
				if (lineItem.getQuantity() > 1) {
					quantity -= 1;
					lineItem.setQuantity(quantity);
					return;
				}
				items.remove(lineItem);
				return;
			}
		}
	}
	public void updateQuantity(LineItem item, int updateQuantity) {
		String id = item.getProduct().getProductCode();
		for (LineItem lineItem : items) {
			if (lineItem.getProduct().getProductCode().equals(id)) {
					lineItem.setQuantity(updateQuantity);
					return;
				}
		}
	}
	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}
	
	
}
