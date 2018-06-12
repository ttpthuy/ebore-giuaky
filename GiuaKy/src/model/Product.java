package model;

import com.sun.prism.Image;

public class Product {
	private String productCode;
	private String productName;
	private double productPrice;
	private String producerID;
	private Image image;
	public Product(String productCode, String productName, double productPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public String getProducerID() {
		return producerID;
	}

	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Product(String productCode, String productName, double productPrice, String producerID, Image image) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.producerID = producerID;
		this.image = image;
	}

	public Product() {
		super();
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public boolean getMe(String procode) {
		if (!this.productCode.equals(procode)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", producerID=" + producerID + "]" + "\n";
	}
	
	
}
