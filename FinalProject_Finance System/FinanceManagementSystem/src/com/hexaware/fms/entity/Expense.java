package com.hexaware.fms.entity;

import java.util.Date;

public class Expense {

	private int expenseId;
//	private User userId;
	private int userId;
	private Double amount;
//	private ExpenseCategory categoryId;
	private int categoryId;
	private Date date;
	private String description;
	
//	public Expense()
//	{
//		
//	}
	public Expense(int expenseId, int userId, Double amount, int categoryId, Date date,
			String description) {
		super();
		this.expenseId = expenseId;
		this.userId = userId;
		this.amount = amount;
		this.categoryId = categoryId;
		this.date = date;
		this.description = description;
	}
	


	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", userId=" + userId + ", amount=" + amount + ", categoryId="
				+ categoryId + ", date=" + date + ", description=" + description + "]";
	}
	
	
	

	
	
	
}
