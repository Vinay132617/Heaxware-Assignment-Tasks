package com.hexaware.electronicgadget.entity;

import java.util.Date;

public class Inventory extends products{
	private int inventoryID;
    private int  productID;
    private int quantityInStock;
    private Date lastStockUpdate;
    
	public Inventory() {
		super();
	}
	public Inventory(int inventoryID, int productID, int quantityInStock, Date lastStockUpdate) {
		   super();
		   this.inventoryID = inventoryID;
	        this.productID = productID;
	        this.quantityInStock = quantityInStock;
	        this.lastStockUpdate = lastStockUpdate;// TODO Auto-generated constructor stub
	}
	public int getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProduct(int productID) {
		this.productID = productID;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public Date getLastStockUpdate() {
		return lastStockUpdate;
	}
	public void setLastStockUpdate(Date lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}
	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", productID=" + productID + ", quantityInStock="
				+ quantityInStock + ", lastStockUpdate=" + lastStockUpdate + "]";
	}
	

}
