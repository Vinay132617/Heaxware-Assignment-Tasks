package com.hexware.electronicgadget.presentation;

import java.util.Scanner;

public class client {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		customerdata c=new customerdata();
		productdata p=new productdata();
		orderdata o=new orderdata();
		orderdetaildata or=new orderdetaildata();
		InventoryData i=new InventoryData();
		boolean flag=true;
		while(flag)
		{System.out.println("***Welcome To TechShop***");
		System.out.println("1.Customer Data");
		System.out.println("2.Product Data");
		System.out.println("3.Orders ");
		System.out.println("4.Orders Details");
		System.out.println("5.Inventory");
		System.out.println("0.Exit");
		int choice=scanner.nextInt();
		switch (choice)
		{ case 1: c.main(args);
		    break;
		case 2: p.main(args);
			break;
		case 3: o.main(args);
			break;
		case 4: or.main(args);
			break;
		case 5: i.main(args);
			break;
		case 0:System.out.println("Exit");
	     break;
		default:System.out.println("Invalid Choice");
		     break;
		}
		
		}
		
     
	}

}
