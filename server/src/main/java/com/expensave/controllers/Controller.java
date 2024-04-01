package com.moneywatcher.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class Controller {

  private UserDao userDao;
  private ExpenseDao expenseDao;

  public Controller(UserDao userDao, ExpenseDao expenseDao) {
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
  public void addExpense(@RequestBody Expense expense, Principal principal) {
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
