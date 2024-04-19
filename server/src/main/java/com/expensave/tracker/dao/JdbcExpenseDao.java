package com.expensave.tracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.expensave.tracker.exception.DaoException;
import com.expensave.tracker.model.Expense;

@Component
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
  public void createExpense(Expense expense) {
    String sql = "INSERT INTO expenses (user_id, amount, description, date) VALUES (?, ?, ?, ?)";
    try {
      jdbcTemplate.update(sql,
          expense.getUserId(), expense.getAmount(),
          expense.getDescription(), expense.getDate());
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
    Expense expense = new Expense();

    expense.setId(results.getInt("expense_id"));
    expense.setUserId(results.getInt("user_id"));
    expense.setAmount(results.getDouble("amount"));
    expense.setDescription(results.getString("description"));
    expense.setDate(results.getDate("date").toLocalDate());

    return expense;
  }
}
