package com.hexaware.electronicgadget.entity;

import java.util.Date;

public class orders extends customer {
	    private int orderID;
	    private int customerID;
	    private Date orderDate;
	    private double totalAmount;
	    private String paymentid;
	    private String orderstatus;
	
	public orders() {
			super();
		}
	public orders(int orderID, int customerID, Date orderDate, double totalAmount, String paymentid,
				String orderstatus) {
			super();
			this.orderID = orderID;
			this.customerID = customerID;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
			this.paymentid = paymentid;
			this.orderstatus = orderstatus;		}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	@Override
	public String toString() {
		return "orders [orderID=" + orderID + ", customerID=" + customerID + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + ", paymentid=" + paymentid + ", orderstatus=" + orderstatus +  "]";
	}
}

	


