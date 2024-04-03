package com.expensave.tracker.dao;

import java.util.List;

import com.expensave.tracker.model.user.RegisterUserDto;
import com.expensave.tracker.model.user.User;

public interface UserDao {

  List<User> getUsers();

  User getUserById(int id);

  User getUserByUsername(String username);

  User createUser(RegisterUserDto user);
}
