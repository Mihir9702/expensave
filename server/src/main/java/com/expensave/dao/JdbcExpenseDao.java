package com.moneywatcher.dao;

import java.util.ArrayList;
import java.util.List;

import com.moneywatcher.model.Expense;

public class JdbcExpenseDao implements ExpenseDao {

  @Override
  public void addExpense(Expense expense) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteExpense(int id) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Expense getExpenseByDate(int month, int day, int year) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Expense getExpenseById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Expense> getExpensesByUserId(int userId) {
    List<Expense> expenses = new ArrayList<Expense>();
    return expenses;
  }

  @Override
  public void updateExpense(Expense expense) {
    // TODO Auto-generated method stub
    
  }

}
