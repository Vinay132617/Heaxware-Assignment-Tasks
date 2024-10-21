package com.hexaware.fms.service;

import com.hexaware.fms.dao.IFinanceDao;
import com.hexaware.fms.dao.FinanceRepositoryImpl;
import com.hexaware.fms.entity.Expense;
import com.hexaware.fms.entity.User;
import myexceptions.UserNotFoundException;
import myexceptions.ExpenseNotFoundException;

import java.util.List;

public class FinanceServiceImpl implements FinanceService {

    private IFinanceDao financeDao;

    public FinanceServiceImpl() {
        this.financeDao = new FinanceRepositoryImpl();  // DAO implementation
    }

    @Override
    public boolean addUser(User user) {
        return financeDao.createUser(user);
    }

    @Override
    public boolean addExpense(Expense expense) {
        return financeDao.createExpense(expense);
    }

    @Override
    public boolean removeUser(int userId) throws UserNotFoundException {
        if (!financeDao.userExists(userId)) {
            throw new UserNotFoundException("User ID " + userId + " does not exist.");
        }
        return financeDao.deleteUser(userId);
    }

    @Override
    public boolean removeExpense(int expenseId) throws ExpenseNotFoundException {
        if (!financeDao.expenseExists(expenseId)) {
            throw new ExpenseNotFoundException("Expense ID " + expenseId + " does not exist.");
        }
        return financeDao.deleteExpense(expenseId);
    }

    @Override
    public List<Expense> listExpenses(int userId) throws UserNotFoundException {
        if (!financeDao.userExists(userId)) {
            throw new UserNotFoundException("User ID " + userId + " does not exist.");
        }
        return financeDao.getAllExpenses(userId);
    }

    @Override
    public boolean updateExpense(int userId, Expense expense) throws UserNotFoundException {
        if (!financeDao.userExists(userId)) {
            throw new UserNotFoundException("User ID " + userId + " does not exist.");
        }
        return financeDao.updateExpense(userId, expense);
    }
}
