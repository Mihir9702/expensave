package com.moneywatcher.dao;

import java.util.List;

import com.moneywatcher.model.Expense;

public interface ExpenseDao {
  List<Expense> getExpensesByUserId(int userId);

  Expense getExpenseById(int id);

  Expense getExpenseByDate(int month, int day, int year);

  void addExpense(Expense expense);

  void updateExpense(Expense expense);

  void deleteExpense(int id);
}
