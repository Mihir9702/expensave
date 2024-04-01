package com.moneywatcher.dao;

import java.util.ArrayList;
import java.util.List;

import com.moneywatcher.model.Expense;

public class JdbcExpenseDao implements ExpenseDao {

  private JdbcTemplate jdbcTemplate;

  public JdbcExpenseDao(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public void addExpense(Expense expense) {
    String sql = "INSERT INTO expenses (title, amount, description, day, month, year, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {
      jdbcTemplate.update(sql, expense.getTitle(), expense.getAmount(), expense.getDescription(), expense.getDay(),
          expense.getMonth(), expense.getYear(), expense.getUserId());
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  @Override
  public void deleteExpense(int id) {
    String sql = "DELETE FROM expenses WHERE id = ?";

    try {
      jdbcTemplate.update(sql, id);
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  @Override
  public Expense getExpenseByDate(int month, int day, int year, int userId) {
    String sql = "SELECT * FROM expenses WHERE month = ? AND day = ? AND year = ? AND user_id = ?";

    try {
      return jdbcTemplate.queryForObject(sql, Expense.class, month, day, year, userId);
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  @Override
  public Expense getExpenseById(int id) {
    String sql = "SELECT * FROM expenses WHERE id = ?";

    try {
      return jdbcTemplate.queryForObject(sql, Expense.class, id);
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  @Override
  public List<Expense> getExpensesByUserId(int userId) {
    String sql = "SELECT * FROM expenses WHERE user_id = ?";

    try {
      return jdbcTemplate.queryForObject(sql, Expense.class, userId);
    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  @Override
  public void updateExpense(int id, String title, double amount, String description) {
    String sql = "update expenses set title = ?, amount = ?, description = ? where id = ?;";

    try {
      jdbcTemplate.update(sql, title, amount, description, id);

    } catch (CannotGetJdbcConnectionException e) {
      throw new DaoException("Unable to connect to server or database", e);
    }
  }

  private Expense mapRow(ResultSet rs, int rowNum) {
    Expense expense = new Expense();
    expense.setId(rs.getInt("id"));
    expense.setTitle(rs.getString("title"));
    expense.setAmount(rs.getDouble("amount"));
    expense.setDescription(rs.getString("description"));
    expense.setDay(rs.getInt("day"));
    expense.setMonth(rs.getInt("month"));
    expense.setYear(rs.getInt("year"));
    return expense;
  }
}
