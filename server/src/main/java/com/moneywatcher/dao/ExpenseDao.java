package com.moneywatcher.dao;

import java.util.List;

import com.moneywatcher.model.Expense;

public interface ExpenseDao {
  List<Expense> getExpensesByUserId(int userId);
}
