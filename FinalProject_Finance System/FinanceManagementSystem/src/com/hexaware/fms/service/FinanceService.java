package com.hexaware.fms.service;

import com.hexaware.fms.entity.Expense;
import com.hexaware.fms.entity.User;

import myexceptions.ExpenseNotFoundException;
import myexceptions.UserNotFoundException;

import java.util.List;

public interface FinanceService {
    boolean addUser(User user);
    boolean addExpense(Expense expense);
    boolean removeUser(int userId) throws UserNotFoundException;
    boolean removeExpense(int expenseId) throws ExpenseNotFoundException;
    List<Expense> listExpenses(int userId) throws UserNotFoundException;
    boolean updateExpense(int userId, Expense expense) throws UserNotFoundException;
}