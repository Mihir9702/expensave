package com.expensave.dao;

import java.util.List;

import com.expensave.model.Expense;

public interface ExpenseDao {
  List<Expense> getExpensesByUserId(int userId);

  Expense getExpenseById(int id);

  Expense getExpenseByDate(int month, int day, int year, int userId);

  void addExpense(Expense expense);

  void updateExpense(Expense expense);

  void deleteExpense(int id);
}
