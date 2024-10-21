package com.hexaware.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hexaware.fms.entity.Expense;
import com.hexaware.fms.entity.ExpenseCategory;
import com.hexaware.fms.entity.User;
import com.hexaware.fms.util.DButil;


public class FinanceRepositoryImpl implements IFinanceDao {
	
		
	
	public FinanceRepositoryImpl() {
		super();
	
	}
	
	private static Connection conn = DButil.getConnection();


	    @Override
	    public boolean createUser(User user) {
	    	
	    	String createUserQuery = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
	    	
	        try (
	            PreparedStatement stmt = conn.prepareStatement(createUserQuery)) {
	            stmt.setString(1, user.getUserName());
	            stmt.setString(2, user.getPassword());
	            stmt.setString(3, user.getEmail());

	            int rowsAffected = stmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	    }

	    

	    @Override
	    public boolean createExpense(Expense expense){
	    	String createExpenseQuery = "INSERT INTO Expenses (user_id, amount, category_id, date, description) VALUES (?, ?, ?, ?, ?)";
	        try (
	             PreparedStatement stmt = conn.prepareStatement(createExpenseQuery)) {
	            stmt.setInt(1, expense.getUserId());
	            stmt.setDouble(2, expense.getAmount());
	            stmt.setInt(3, expense.getCategoryId());
	            stmt.setDate(4, new java.sql.Date(expense.getDate().getTime()));
	            stmt.setString(5, expense.getDescription());
	            int rowsAffected = stmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	           return false;
	        }
	    }
    
   
	@Override
	public boolean deleteUser(int userId) {
		
		String deleteUserQuery = "DELETE FROM Users WHERE user_id = ?";
		try (

	            PreparedStatement stmt = conn.prepareStatement(deleteUserQuery)) {
	            stmt.setInt(1, userId);
	            int rowsAffected = stmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	           return false;
	        }
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		
		String deleteExpenseQuery = "DELETE FROM Expenses WHERE expense_id = ?";
		try (
	            PreparedStatement stmt = conn.prepareStatement(deleteExpenseQuery)) {
	            stmt.setInt(1, expenseId);
	            int rowsAffected = stmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}

	    
	@Override
	public boolean updateExpense(int userId, Expense expense) {
		
		String updateExpenseQuery = "UPDATE Expenses SET amount = ?, category_id = ?, date = ?, description = ? WHERE expense_id = ? AND user_id = ?";
		
		 try (
	            PreparedStatement stmt = conn.prepareStatement(updateExpenseQuery)) {
	            stmt.setDouble(1, expense.getAmount());
	            stmt.setInt(2, expense.getCategoryId());
	            stmt.setDate(3, new java.sql.Date(expense.getDate().getTime()));
	            stmt.setString(4, expense.getDescription());
	            stmt.setInt(5, expense.getExpenseId());
	            stmt.setInt(6, userId);
	            int rowsAffected = stmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	         return false;
	        }
	}



	@Override
	public List<Expense> getAllExpenses(int userId) {
	    String getAllExpensesQuery = "SELECT e.expense_id, e.amount, e.date, e.description, e.category_id, c.category_name " +
	                                  "FROM Expenses e JOIN ExpenseCategories c ON e.category_id = c.category_id " +
	                                  "WHERE e.user_id = ?";
	    List<Expense> expenses = new ArrayList<>();

	    try (PreparedStatement stmt = conn.prepareStatement(getAllExpensesQuery)) {
	        stmt.setInt(1, userId);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Expense expense = new Expense(userId, userId, null, userId, null, getAllExpensesQuery);
	            expense.setExpenseId(rs.getInt("expense_id"));
	            expense.setAmount(rs.getDouble("amount"));
	            expense.setDate(rs.getDate("date"));
	            expense.setDescription(rs.getString("description"));
	            expense.setCategoryId(rs.getInt("category_id"));
	            

	            expenses.add(expense);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    return expenses;
	}
	
	
	
	
	 @Override
	    public boolean userExists(int userId) {
	        try {
	            String query = "SELECT COUNT(*) FROM users WHERE user_id = ?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, userId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                return resultSet.getInt(1) > 0; // Returns true if count > 0
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }
	        return false; // User does not exist
	    }

	    @Override
	    public boolean expenseExists(int expenseId) {
	        try {
	            String query = "SELECT COUNT(*) FROM expenses WHERE expense_id = ?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, expenseId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                return resultSet.getInt(1) > 0; // Returns true if count > 0
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }
	        return false; // Expense does not exist
	    }

}
	
	
	
	
	