package com.expensave.tracker.model;

import java.util.Date;

public class Expense {
  private int id;
  private int userId;
  private String title;
  private double amount;
  private String description;
  private Date date;

  public Expense() {
  }

  public Expense(int id, int userId, String title, double amount, String description, Date date) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.amount = amount;
    this.description = description;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
