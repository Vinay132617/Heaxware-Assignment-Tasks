package com.hexaware.electronicgadget.dao;
import java.util.List;

import com.hexaware.electronicgadget.entity.Inventory;
import com.hexaware.electronicgadget.entity.customer;
import com.hexaware.electronicgadget.entity.orderdetails;
import com.hexaware.electronicgadget.entity.orders;
import com.hexaware.electronicgadget.entity.products;

public interface IElectronicDao {
	
	List<customer> allcustomer();
	List<Inventory> allInventory();
	List<orderdetails> allorderdetails();
	List<orders> allorders();
	List<products> allproducts();
	int addcustomer(customer cust);
	int updatecustomer(customer cust);
	int deletecustomer(int customerID);
	int newproduct(products pro);
	int updateproduct(products pro);
    int deleteproduct(int productID);
    int addorder(orders ord);
	int updateorder(orders ord);
	int deleteorder(int orderID);
	int cancelorder(orders ord);
	int addinventory(Inventory inv);
	int updateinventory(Inventory inv);
	int deleteinventory(int inventoryID);
	Inventory inventoryvalue(Inventory inv);
	int updatequantity(Inventory inv);
	List<orders>  totalorders();
	List<orders> payments();
	List<orders> orderstatus();
	List<Inventory> quantityinstock();
	List<Inventory> lowstockproducts();
	List<Inventory> outofstock();
	List<orders> totalamount();
	products getbyPid(int productID);
	products getbyPname(String productname);
	Inventory isproductinstock(int productID);
}
