package com.hexaware.fms.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.fms.dao.FinanceRepositoryImpl;
import com.hexaware.fms.entity.Expense;
import com.hexaware.fms.entity.User;
import com.hexaware.fms.service.FinanceServiceImpl;

class FinanceTests {

    static FinanceServiceImpl financeService;
    static FinanceRepositoryImpl financeRepository;
//
    @BeforeAll
    public static void beforeAll() {
        financeService = new FinanceServiceImpl();
    }

    @Test
    void testAddUser() {
        User user = new User(100, "User", "word", "test@example.com");
        boolean result = financeService.addUser(user);
        assertTrue(result, "User should be created successfully.");
    }
    
    @Test
    void testAddExpense() {
        Expense expense = new Expense(1, 1, 100.0, 1, new java.util.Date(), "Test expense");
        boolean result = financeService.addExpense(expense);
        assertTrue(result, "Expense should be created successfully.");
    }
    

    @BeforeAll
    public static void beforeAll1() {
        financeRepository = new FinanceRepositoryImpl();
    }

    // Test case for searching expenses by user ID (positive case)
    @Test
    void testGetAllExpensesByUserIdSuccess() {
        int validUserId = 1;  // Assume this user exists in the database and has expenses

        List<Expense> expenses = financeRepository.getAllExpenses(validUserId);

        assertNotNull(expenses, "Expenses list should not be null");
        assertFalse(expenses.isEmpty(), "Expenses list should not be empty for a valid user");
        
        // Assuming the first expense has known values
        Expense firstExpense = expenses.get(0);
        assertEquals(validUserId, firstExpense.getUserId(), "User ID should match");
        assertTrue(firstExpense.getAmount() > 0, "Expense amount should be greater than zero");
        assertNotNull(firstExpense.getDescription(), "Expense description should not be null");
    }

    // Test case for searching expenses by user ID (no expenses found)
    @Test
    void testGetAllExpensesByUserIdNoExpenses() {
        int userIdWithNoExpenses = 1000;  // Assume this user ID does not exist or has no expenses

        List<Expense> expenses = financeRepository.getAllExpenses(userIdWithNoExpenses);

        assertNotNull(expenses, "Expenses list should not be null, even if no expenses found");
        assertTrue(expenses.isEmpty(), "Expenses list should be empty for a user with no expenses");
    }


}
