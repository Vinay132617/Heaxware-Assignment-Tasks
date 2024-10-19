package com.hexaware.electronicgadget.service;

import java.util.List;

import com.hexaware.electronicgadget.dao.ElectronicDaoImp;
import com.hexaware.electronicgadget.dao.IElectronicDao;
import com.hexaware.electronicgadget.entity.Inventory;
import com.hexaware.electronicgadget.entity.customer;
import com.hexaware.electronicgadget.entity.orderdetails;
import com.hexaware.electronicgadget.entity.orders;
import com.hexaware.electronicgadget.entity.products;
import com.hexaware.electronicgadget.exception.InvalidDataException;

public class ElectronicServiceImp implements IElectronicService{
        private IElectronicDao dao;
        public ElectronicServiceImp()
        { dao= new ElectronicDaoImp();}
	@Override
	public List<customer> allcustomer() {
		// TODO Auto-generated method stub
		return dao.allcustomer();
	}

	@Override
	public List<Inventory> allInventory() {
		// TODO Auto-generated method stub
		return dao.allInventory();
	}

	@Override
	public List<orderdetails> allorderdetails() {
		// TODO Auto-generated method stub
		return dao.allorderdetails();
	}

	@Override
	public List<orders> allorders() {
		// TODO Auto-generated method stub
		return dao.allorders();
	}

	@Override
	public List<products> allproducts() {
		// TODO Auto-generated method stub
		return dao.allproducts();
	}

	@Override
	public int addcustomer(customer cust) {
		// TODO Auto-generated method stub
		return dao.addcustomer(cust);
	}

	@Override
	public int updatecustomer(customer cust) {
		// TODO Auto-generated method stub
		return dao.updatecustomer(cust);
	}

	@Override
	public int deletecustomer(int customerID) {
		// TODO Auto-generated method stub
		return dao.deletecustomer(customerID);
	}

	@Override
	public int newproduct(products pro) {
		// TODO Auto-generated method stub
		return dao.newproduct(pro);
	}

	@Override
	public int updateproduct(products pro) {
		// TODO Auto-generated method stub
		return dao.updateproduct(pro);
	}

	@Override
	public int deleteproduct(int productID) {
		// TODO Auto-generated method stub
		return dao.deleteproduct(productID);
	}

	@Override
	public int addorder(orders ord) {
		// TODO Auto-generated method stub
		return dao.addorder(ord);
	}

	@Override
	public int updateorder(orders ord) {
		// TODO Auto-generated method stub
		return dao.updateorder(ord);
	}

	@Override
	public int deleteorder(int orderID) {
		// TODO Auto-generated method stub
		return dao.deleteorder(orderID);
	}

	@Override
	public int updateinventory(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.updateinventory(inv);
	}

	@Override
	public List<orders> totalorders() {
		// TODO Auto-generated method stub
		return dao.totalorders();
	}

	@Override
	public List<orders> payments() {
		// TODO Auto-generated method stub
		return dao.payments();
	}

	@Override
	public List<orders> orderstatus() {
		// TODO Auto-generated method stub
		return dao.orderstatus();
	}

	@Override
	public products getbyPid(int productID) {
		// TODO Auto-generated method stub
		return dao.getbyPid(productID);
	}

	@Override
	public products getbyPname(String productname) {
		// TODO Auto-generated method stub
		return dao.getbyPname(productname);
	}
	@Override
	public int cancelorder(orders ord) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int addinventory(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.addinventory(inv);
	}
	@Override
	public int deleteinventory(int inventoryID) {
		// TODO Auto-generated method stub
		return dao.deleteinventory(inventoryID);
	}
	@Override
	public Inventory inventoryvalue(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.inventoryvalue(inv);
	}
	@Override
	public int updatequantity(Inventory inv) {
		// TODO Auto-generated method stub
		return dao.updatequantity(inv);
	}
	@Override
	public List<Inventory> quantityinstock() {
		// TODO Auto-generated method stub
		return dao.quantityinstock();
	}
	@Override
	public List<Inventory> lowstockproducts() {
		// TODO Auto-generated method stub
		return dao.lowstockproducts();
	}
	@Override
	public List<Inventory> outofstock() {
		// TODO Auto-generated method stub
		return dao.outofstock();
	}
	@Override
	public List<orders> totalamount() {
		// TODO Auto-generated method stub
		return dao.totalamount();
	}
	@Override
	public Inventory isproductinstock(int productID) {
		// TODO Auto-generated method stub
		return dao.isproductinstock(productID);
	}

public static boolean validateCst (customer cust) throws InvalidDataException
{  
	
	
	boolean flag=false;
	if(cust.getCustomerID()>100 && cust.getFirstName().length()>5 && cust.getLastName().length()>3 && cust.getEmail().length()>7 && cust.getPhone().length()>9 && cust.getAddress().length()>5) {
		
		flag=true;
		
	}
	else
	{ throw new InvalidDataException("Invalid Email or Data ");}
	return flag;
 
}


}
