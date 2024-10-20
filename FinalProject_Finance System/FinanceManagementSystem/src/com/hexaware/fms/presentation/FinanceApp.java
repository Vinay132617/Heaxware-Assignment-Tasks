package com.hexaware.fms.presentation;

import com.hexaware.fms.entity.Expense;
import com.hexaware.fms.entity.User;
import com.hexaware.fms.service.FinanceService;
import com.hexaware.fms.service.FinanceServiceImpl;

import myexceptions.ExpenseNotFoundException;
import myexceptions.UserNotFoundException;

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
    

	private static void addUser(Scanner sc) {
	        System.out.print("Enter username: ");
	        String username = sc.nextLine();
	        System.out.print("Enter password: ");
	        String password = sc.nextLine();
	        System.out.print("Enter email: ");
	        String email = sc.nextLine();
	
	        User user = new User(0, username, password, email);  // Assuming ID will be auto-generated
	        boolean result = financeService.addUser(user);
	        System.out.println(result ? "User added successfully." : "Failed to add user.");
	    }

    private static void addExpense(Scanner sc) {
        System.out.print("Enter user ID: ");
        int userId = sc.nextInt();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();  // Consume newline
        System.out.print("Enter category ID: ");
        int categoryId = sc.nextInt();
        System.out.print("Enter description: ");
        sc.nextLine();
        String description = sc.nextLine();

        Expense expense = new Expense(0, userId, amount, categoryId, new java.util.Date(), description);
        boolean result = financeService.addExpense(expense);
        System.out.println(result ? "Expense added successfully." : "Failed to add expense.");
    }

    private static void deleteUser(Scanner sc) throws UserNotFoundException {
        System.out.print("Enter user ID to delete: ");
        int userId = sc.nextInt();
        boolean result = financeService.removeUser(userId);
        System.out.println(result ? "User deleted successfully." : "Failed to delete user.");
    }
    

private static void deleteExpense(Scanner sc) throws ExpenseNotFoundException {
        System.out.print("Enter expense ID to delete: ");
        int expenseId = sc.nextInt();
        boolean result = financeService.removeExpense(expenseId);
        System.out.println(result ? "Expense deleted successfully." : "Failed to delete expense.");
    }

    private static void updateExpense(Scanner sc) throws UserNotFoundException {
        System.out.print("Enter user ID: ");
        int userId = sc.nextInt();
        System.out.print("Enter expense ID to update: ");
        int expenseId = sc.nextInt();
        System.out.print("Enter new amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();  // Consume newline
        System.out.print("Enter new category ID: ");
        int categoryId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new description: ");
        String description = sc.nextLine();

        Expense expense = new Expense(expenseId, userId, amount, categoryId, new java.util.Date(), description);
        boolean result = financeService.updateExpense(userId, expense);
        System.out.println(result ? "Expense updated successfully." : "Failed to update expense.");
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