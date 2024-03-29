package com.moneywatcher.security.dao;

import java.util.List;

import com.moneywatcher.security.model.RegisterUserDto;
import com.moneywatcher.security.model.User;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
