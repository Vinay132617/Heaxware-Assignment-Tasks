package com.hexware.electronicgadget.presentation;

import java.util.List;
import java.util.Scanner;

import com.hexaware.electronicgadget.entity.Inventory;
import com.hexaware.electronicgadget.entity.customer;
import com.hexaware.electronicgadget.entity.orderdetails;
import com.hexaware.electronicgadget.entity.orders;
import com.hexaware.electronicgadget.entity.products;
import com.hexaware.electronicgadget.service.ElectronicServiceImp;

public class orderdetaildata {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
	ElectronicServiceImp service=new ElectronicServiceImp();
	System.out.println("***Welcome To Order Details***");
    System.out.println("1.SubTotal of Order");
    System.out.println("2.Display all Orders Details");
    System.out.println("3.Update Quantity");
 int choice4=scanner.nextInt();
 	switch(choice4)
 	{ case 1: List<orders> list1 = service.totalamount();

 		for (orders ord1 : list1) {

 			System.out.println(ord1);

 			}
 		break;
      case 2: List<orderdetails> list2 = service.allorderdetails();

		for (orderdetails ord2 : list2) {

			System.out.println(ord2);

			}
    	  break;
      case 3: Inventory inv2=readordData();
	     int count1 =	service.updatequantity(inv2);
			
  		if(count1>0) {
  				System.out.println("Quantity updated");
  				}
  		else{
	      System.err.println("Quantity Update failed");
	
  			}
    	  break;
 	default:System.out.println("Invalid Choice");
 		break;
 	}

	}
	public static Inventory readordData()
	{ Inventory inv3=new Inventory();
	System.out.println("Enter ProductID=");
	inv3.setProductID(scanner.nextInt());
	return inv3;
	}

}
