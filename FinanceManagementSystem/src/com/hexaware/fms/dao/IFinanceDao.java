package com.hexaware.fms.dao;

import com.hexaware.fms.entity.Expense;
import com.hexaware.fms.entity.User;
import java.util.List;

public interface IFinanceDao {

	    boolean createUser(User user);
	    boolean createExpense(Expense expense);
	    boolean deleteUser(int userId);
	    boolean deleteExpense(int expenseId);
	    
	    List<Expense> getAllExpenses(int userId);
	    
	    boolean updateExpense(int userId, Expense expense);
	    
	    
	    boolean userExists(int userId); 
	    boolean expenseExists(int expenseId);
	
}
