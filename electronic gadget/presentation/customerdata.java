package com.hexware.electronicgadget.presentation;

import java.util.List;
import java.util.Scanner;

import com.hexaware.electronicgadget.entity.customer;
import com.hexaware.electronicgadget.entity.orders;
import com.hexaware.electronicgadget.exception.InvalidDataException;
import com.hexaware.electronicgadget.service.ElectronicServiceImp;

public class customerdata {

	   static Scanner scanner=new Scanner(System.in);
		public static void main(String[] args) {
		ElectronicServiceImp service=new ElectronicServiceImp();
		System.out.println("***Welcome To Customer Data***");
		System.out.println("1.Display All Customers");
		System.out.println("2.Update Customer");
		System.out.println("3.Total Order by Customer");
		System.out.println("4.Add Customers");
		
		int choice1=scanner.nextInt();
		switch(choice1)
		{ case 1: List<customer> list = service.allcustomer();

		            for (customer cust : list) {

			            System.out.println(cust);

		                }
			 break;
		case 2: customer cust=readCustData();
		     int count1 =	service.updatecustomer(cust);
		
		     		if(count1>0) {
		     				System.out.println("Customer updated");
		     				}
		     		else{
			      System.err.println("Customer Update failed");
			
		     			}
			 break;
		case 3: List<orders> list1 = service.totalorders();

                for (orders ord1 : list1) {

                 System.out.println(ord1);

                  }
			 break;
		case 4:try { customer cust1=readCustData();
		
			boolean isValid;
			
				isValid = ElectronicServiceImp.validateCst(cust1);
			 
		
		if(isValid) {
			int count =	service.addcustomer(cust1);
			
			if(count>0) {
				System.out.println("Customer Added");
			}
			else{
				System.err.println("Customer Added failed");
				
			}	
			
		}}
		catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		default:System.out.println("Invalid Choice");
	     break;
		
		}
	}
		public static customer readCustData(){
			customer cust= new customer();
			
			System.out.println("Enter CustomerID=");
				cust.setCustomerID(scanner.nextInt());
			System.out.println("Enter Customer FirstName=");
				cust.setFirstName(scanner.next());
			System.out.println("Enter Customer Last1Name=");
				cust.setLastName(scanner.next());
			System.out.println("Enter Customer Email=");
				cust.setEmail(scanner.next());
			System.out.println("Enter Phone number=");
				cust.setPhone(scanner.next());
			System.out.println("Enter Address=");
				cust.setAddress(scanner.next());
			
			return cust;
		}	

}
