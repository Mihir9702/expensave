package com.expensave.tracker.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.expensave.tracker.dao.UserDao;
import com.expensave.tracker.exception.DaoException;
import com.expensave.tracker.model.user.LoginDto;
import com.expensave.tracker.model.user.LoginResponseDto;
import com.expensave.tracker.model.user.RegisterUserDto;
import com.expensave.tracker.model.user.User;
import com.expensave.tracker.security.jwt.JWTFilter;
import com.expensave.tracker.security.jwt.TokenProvider;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class AuthenticationController {

  private final TokenProvider tokenProvider;
  private final AuthenticationManagerBuilder authenticationManagerBuilder;
  private final UserDao userDao;

  public AuthenticationController(TokenProvider tokenProvider,
      AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao) {
    this.tokenProvider = tokenProvider;
    this.authenticationManagerBuilder = authenticationManagerBuilder;
    this.userDao = userDao;
  }

  @RequestMapping(path = "/login", method = RequestMethod.POST)
  public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) {

    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        loginDto.getUsername(), loginDto.getPassword());

    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = tokenProvider.createToken(authentication, false);

    User user;
    try {
      user = userDao.getUserByUsername(loginDto.getUsername());
    } catch (DaoException e) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is incorrect.");
    }

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
    return new ResponseEntity<>(new LoginResponseDto(jwt, user), httpHeaders, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @RequestMapping(path = "/signup", method = RequestMethod.POST)
  public void signup(@Valid @RequestBody RegisterUserDto newUser) {
    try {
      User user = userDao.createUser(newUser);
      if (user == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User registration failed.");
      }
    } catch (DaoException e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User registration failed.");
    }
  }

}
