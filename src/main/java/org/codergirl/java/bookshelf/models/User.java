package org.codergirl.java.bookshelf.models;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class User {
  private String username;
  private String passwordHash;

  public User(){}

  public User(String username, String password) {
    setUsername(username);
    setPassword(password);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(username, user.username) &&
        Objects.equals(passwordHash, user.passwordHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, passwordHash);
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.passwordHash = Hashing.sha256()
        .hashString(password, StandardCharsets.UTF_8)
        .toString();
  }

  public String getUsername() {
    return username;
  }

  public String getPasswordHash() {
    return passwordHash;
  }
}
