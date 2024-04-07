package com.expensave.tracker.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensave.tracker.dao.ExpenseDao;
import com.expensave.tracker.dao.UserDao;
import com.expensave.tracker.model.Expense;
import com.expensave.tracker.model.user.User;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ExpenseController {

  private UserDao userDao;
  private ExpenseDao expenseDao;

  public ExpenseController(UserDao userDao, ExpenseDao expenseDao) {
    this.userDao = userDao;
    this.expenseDao = expenseDao;
  }

  @GetMapping("/expenses")
  public List<Expense> getExpensesByUserId(Principal principal) {
    String username = principal.getName();
    User user = userDao.getUserByUsername(username);
    int userId = user.getId();
    return expenseDao.getExpensesByUserId(userId);
  }

  @GetMapping("/expenses/{id}")
  public Expense getExpenseById(@PathVariable int id) {
    return expenseDao.getExpenseById(id);
  }

  @PostMapping("/expenses")
  public void addExpense(@Valid @RequestBody Expense expense, Principal principal) {
    String username = principal.getName();
    User user = userDao.getUserByUsername(username);
    expense.setUserId(user.getId());
    expenseDao.addExpense(expense);
  }

  @PutMapping("/expenses")
  public void updateExpense(@RequestBody Expense expense) {
    expenseDao.updateExpense(expense);
  }

  @DeleteMapping("/expenses/{id}")
  public void deleteExpense(@PathVariable int id) {
    expenseDao.deleteExpense(id);
  }

}
