package com.hexaware.electronicgadget.entity;

public class customer {
	private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    public customer() {
		super();// TODO Auto-generated constructor stub
	}
	public customer(int customerID, String firstName, String lastName, String email, String phone, String address) {
		    super();
		    this.customerID = customerID;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.phone = phone;
	        this.address = address;// TODO Auto-generated constructor stub
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", address=" + address + "]";
	}
	

}
