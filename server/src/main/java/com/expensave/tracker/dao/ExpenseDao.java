package com.expensave.tracker.dao;

import java.util.List;

import com.expensave.tracker.model.Expense;

public interface ExpenseDao {
  List<Expense> getExpensesByUserId(int userId);

  Expense getExpenseById(int id);

  void addExpense(Expense expense);

  void updateExpense(Expense expense);

  void deleteExpense(int id);
}
