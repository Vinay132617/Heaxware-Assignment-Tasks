package com.hexaware.electronicgadget.entity;

public class products {
	private int productID;
    private String productName;
    private String description;
    private double price;
     
	public products() {
		super();
	}

	public products(int productID, String productName, String description, double price) {
		super();
		this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;// TODO Auto-generated constructor stub
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "products [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + "]";
	}

}
