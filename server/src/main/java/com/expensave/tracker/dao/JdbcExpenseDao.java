package com.expensave.tracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.expensave.tracker.exception.DaoException;
import com.expensave.tracker.model.Expense;

public class JdbcExpenseDao implements ExpenseDao {

  private JdbcTemplate jdbcTemplate;

  public JdbcExpenseDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Expense> getExpensesByUserId(int userId) {
    List<Expense> expenses = new ArrayList<>();
    String sql = "SELECT * FROM expenses WHERE user_id = ?";
    try {
      SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

      while (results.next()) {
        Expense expense = mapRowToExpense(results);
        expenses.add(expense);
      }

      if (expenses.size() == 0) {
        throw new DaoException("No expenses found for user"
            + " with id " + userId);
      }

      return expenses;
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  @Override
  public Expense getExpenseById(int id) {
    Expense expense = null;
    String sql = "SELECT * FROM expenses WHERE expense_id = ?";
    try {
      SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

      if (results.next()) {
        expense = mapRowToExpense(results);
      }

      if (expense != null) {
        return expense;
      } else {
        throw new DaoException("Expense not found");
      }
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }

  }

  @Override
  public void addExpense(Expense expense) {
    String sql = "INSERT INTO expenses (user_id, title, amount, description, date) VALUES (?, ?, ?, ?, ?)";
    try {
      jdbcTemplate.update(sql,
          expense.getUserId(), expense.getTitle(), expense.getAmount(), expense.getDescription(), expense.getDate());
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  @Override
  public void updateExpense(Expense expense) {
    String sql = "UPDATE expenses SET title = ?, amount = ?, description = ?, date = ? WHERE expense_id = ?";
    try {
      jdbcTemplate.update(sql,
          expense.getTitle(), expense.getAmount(), expense.getDescription(), expense.getDate(), expense.getId());
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  @Override
  public void deleteExpense(int id) {
    String sql = "DELETE FROM expenses WHERE expense_id = ?";
    try {
      jdbcTemplate.update(sql, id);
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  private Expense mapRowToExpense(SqlRowSet results) {
    return new Expense(
        results.getInt("expense_id"),
        results.getInt("user_id"),
        results.getString("title"),
        results.getDouble("amount"),
        results.getString("description"),
        results.getDate("date"));
  }
}