package org.codergirl.java.bookshelf.controllers;

import org.codergirl.java.bookshelf.dao.LoginDAO;
import org.codergirl.java.bookshelf.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("session")
public class LoginController {

  @Autowired
  private LoginDAO loginDAO;

  @Autowired
  private User user;

  @GetMapping("/login")
  public String display() {
    return "login.html";
  }

  @PostMapping("/login")
  public String login(@RequestParam String username, @RequestParam String password) {
    user = new User(username, password);

    if (loginDAO.isValidUser(user)) {
      // TODO: set session variable
      return "bookmarks.html";
    }
    else {
      return "loginError.html";
    }
  }

}
