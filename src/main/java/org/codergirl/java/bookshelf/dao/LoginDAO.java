package org.codergirl.java.bookshelf.dao;

import org.codergirl.java.bookshelf.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public boolean isValidUser(User user) {

    try {
      String username =
          jdbcTemplate.queryForObject("select username from bookshelf.users " +
          "where username=? and password=?", new Object[]{
              user.getUsername(), user.getPasswordHash()}, String.class);
    } catch (EmptyResultDataAccessException e) {
      // Couldn't find the user.
      return false;
    }

    return true;
  }


}
