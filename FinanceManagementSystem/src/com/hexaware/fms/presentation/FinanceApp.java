package com.hexaware.fms.presentation;

import com.hexaware.fms.entity.Expense;
import com.hexaware.fms.entity.User;
import com.hexaware.fms.service.FinanceService;
import com.hexaware.fms.service.FinanceServiceImpl;
import com.hexaware.fms.util.*;

import myexceptions.*;

import java.util.List;
import java.util.Scanner;

public class FinanceApp {

    private static FinanceService financeService = new FinanceServiceImpl();

    public static void main(String[] args) throws UserNotFoundException, ExpenseNotFoundException {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("---- Finance Management System ----");
            System.out.println("1. Add User");
            System.out.println("2. Add Expense");
            System.out.println("3. Delete User");
            System.out.println("4. Delete Expense");
            System.out.println("5. Update Expense");
            System.out.println("6. List All Expenses for a User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addUser(sc);
                    break;
                case 2:
                    addExpense(sc);
                    break;
                case 3:
                    deleteUser(sc);
                    break;
                case 4:
                    deleteExpense(sc);
                    break;
                case 5:
                    updateExpense(sc);
                    break;
                case 6:
                    listExpenses(sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }
    

//	private static void addUser(Scanner sc) {
//	        System.out.print("Enter username: ");
//	        String username = sc.nextLine();
//	        System.out.print("Enter password: ");
//	        String password = sc.nextLine();
//	        System.out.print("Enter email: ");
//	        String email = sc.nextLine();
//	
//	        User user = new User(0, username, password, email);  // Assuming ID will be auto-generated
//	        boolean result = financeService.addUser(user);
//	        System.out.println(result ? "User added successfully." : "Failed to add user.");
//	    }
    
    private static void addUser(Scanner sc) {
        try {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            // Validate username
            if (username == null || username.trim().isEmpty()) {
                throw new InvalidException("Username cannot be empty.");
            }

            System.out.print("Enter password: ");
            String password = sc.nextLine();
            // Validate password (e.g., must be at least 6 characters long)
            if (password == null || password.length() < 6) {
                throw new InvalidException("Password must be at least 6 characters long.");
            }

            System.out.print("Enter email: ");
            String email = sc.nextLine();
            // Validate email (simple regex validation for format)
            if (email == null) {
                throw new InvalidException("Invalid email format.");
            }

            // If all inputs are valid, create the user and add it
            User user = new User(0, username, password, email);  // Assuming ID is auto-generated
            boolean result = financeService.addUser(user);
            System.out.println(result ? "User added successfully." : "Failed to add user.");

        } catch (InvalidException e) {
            // Handle the validation errors
            System.out.println("Error: " + e.getMessage());
        }
    }

//    private static void addExpense(Scanner sc) {
//        System.out.print("Enter user ID: ");
//        int userId = sc.nextInt();
//        System.out.print("Enter amount: ");
//        double amount = sc.nextDouble();
//        sc.nextLine();  // Consume newline
//        System.out.print("Enter category ID: ");
//        int categoryId = sc.nextInt();
//        System.out.print("Enter description: ");
//        sc.nextLine();
//        String description = sc.nextLine();
//
//        Expense expense = new Expense(0, userId, amount, categoryId, new java.util.Date(), description);
//        boolean result = financeService.addExpense(expense);
//        System.out.println(result ? "Expense added successfully." : "Failed to add expense.");
//    }
    
    private static void addExpense(Scanner sc) {
        try {
            // Validate user ID
            System.out.print("Enter user ID: ");
            int userId = sc.nextInt();
            if (userId <= 0) {
                throw new InvalidException("User ID must be a positive integer.");
            }

            // Validate amount
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            if (amount <= 0) {
                throw new InvalidException("Amount must be greater than zero.");
            }

            sc.nextLine();  // Consume newline

            // Validate category ID
            System.out.print("Enter category ID: ");
            int categoryId = sc.nextInt();
            if (categoryId <= 0) {
                throw new InvalidException("Category ID must be a positive integer.");
            }

            sc.nextLine();  // Consume newline

            // Validate description
            System.out.print("Enter description: ");
            String description = sc.nextLine();
            if (description == null || description.trim().isEmpty()) {
                throw new InvalidException("Description cannot be empty.");
            }

            // Create and add expense if all validations pass
            Expense expense = new Expense(0, userId, amount, categoryId, new java.util.Date(), description);
            boolean result = financeService.addExpense(expense);
            System.out.println(result ? "Expense added successfully." : "Failed to add expense.");

        } catch (InvalidException e) {
            // Handle validation errors
            System.out.println("Error: " + e.getMessage());
        } 
    }


//    private static void deleteUser(Scanner sc) throws UserNotFoundException {
//        System.out.print("Enter user ID to delete: ");
//        int userId = sc.nextInt();
//        boolean result = financeService.removeUser(userId);
//        System.out.println(result ? "User deleted successfully." : "Failed to delete user.");
//    }
    private static void deleteUser(Scanner sc) {
        try {
            System.out.print("Enter user ID to delete: ");
            int userId = sc.nextInt();
            
            // Validate user ID
            if (userId <= 0) {
                throw new InvalidException("User ID must be a positive number.");
            }

            boolean result = financeService.removeUser(userId);
            System.out.println(result ? "User deleted successfully." : "Failed to delete user.");
            
        } catch (InvalidException e) {
            // Handle invalid input errors
            System.out.println("Error: " + e.getMessage());
        } catch (UserNotFoundException e) {
            // Handle user not found errors
            System.out.println("Error: User not found with ID: " + e.getMessage());
        } 
    }

    

//private static void deleteExpense(Scanner sc) throws ExpenseNotFoundException {
//        System.out.print("Enter expense ID to delete: ");
//        int expenseId = sc.nextInt();
//        boolean result = financeService.removeExpense(expenseId);
//        System.out.println(result ? "Expense deleted successfully." : "Failed to delete expense.");
//    }

    private static void deleteExpense(Scanner sc) {
        try {
            System.out.print("Enter expense ID to delete: ");
            int expenseId = sc.nextInt();
            
            // Validate expense ID
            if (expenseId <= 0) {
                throw new InvalidException("Expense ID must be a positive integer.");
            }

            boolean result = financeService.removeExpense(expenseId);
            System.out.println(result ? "Expense deleted successfully." : "Failed to delete expense.");

        } catch (InvalidException e) {
            // Handle invalid input errors
            System.out.println("Error: " + e.getMessage());
        } catch (ExpenseNotFoundException e) {
            // Handle expense not found errors
            System.out.println("Error: Expense not found.");
        }
    }

//    private static void updateExpense(Scanner sc) throws UserNotFoundException {
//        System.out.print("Enter user ID: ");
//        int userId = sc.nextInt();
//        System.out.print("Enter expense ID to update: ");
//        int expenseId = sc.nextInt();
//        System.out.print("Enter new amount: ");
//        double amount = sc.nextDouble();
//        sc.nextLine();  // Consume newline
//        System.out.print("Enter new category ID: ");
//        int categoryId = sc.nextInt();
//        sc.nextLine();
//        System.out.print("Enter new description: ");
//        String description = sc.nextLine();
//
//        Expense expense = new Expense(expenseId, userId, amount, categoryId, new java.util.Date(), description);
//        boolean result = financeService.updateExpense(userId, expense);
//        System.out.println(result ? "Expense updated successfully." : "Failed to update expense.");
//    }
    	
    private static void updateExpense(Scanner sc) {
        try {
            // Validate user ID
            System.out.print("Enter user ID: ");
            int userId = sc.nextInt();
            if (userId <= 0) {
                throw new InvalidException("User ID must be a positive integer.");
            }

            // Validate expense ID
            System.out.print("Enter expense ID to update: ");
            int expenseId = sc.nextInt();
            if (expenseId <= 0) {
                throw new InvalidException("Expense ID must be a positive integer.");
            }

            // Validate amount
            System.out.print("Enter new amount: ");
            double amount = sc.nextDouble();
            if (amount <= 0) {
                throw new InvalidException("Amount must be greater than zero.");
            }

            sc.nextLine();  // Consume newline

            // Validate category ID
            System.out.print("Enter new category ID: ");
            int categoryId = sc.nextInt();
            if (categoryId <= 0) {
                throw new InvalidException("Category ID must be a positive integer.");
            }

            sc.nextLine();  // Consume newline

            // Validate description
            System.out.print("Enter new description: ");
            String description = sc.nextLine();
            if (description == null || description.trim().isEmpty()) {
                throw new InvalidException("Description cannot be empty.");
            }

            // Create and update the expense
            Expense expense = new Expense(expenseId, userId, amount, categoryId, new java.util.Date(), description);
            boolean result = financeService.updateExpense(userId, expense);
            System.out.println(result ? "Expense updated successfully." : "Failed to update expense.");

        } catch (InvalidException e) {
            // Handle validation errors
            System.out.println("Error: " + e.getMessage());
        } catch (UserNotFoundException e) {
            // Handle user not found errors
            System.out.println("Error: User not found.");
        } 
    }

    

private static void listExpenses(Scanner sc) throws UserNotFoundException {
        System.out.print("Enter user ID to list expenses: ");
        int userId = sc.nextInt();
        List<Expense> expenses = financeService.listExpenses(userId);

        if (expenses.isEmpty()) {
            System.out.println("No expenses found for this user.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }
}