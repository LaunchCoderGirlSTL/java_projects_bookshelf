package org.codergirl.java.bookshelf.models;

import com.google.common.hash.Hashing;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Component
@Scope("session")
public class User {
  private String username;
  private String passwordHash;

  public User(){}

  public User(String username, String password) {
    this.username = username;
    this.passwordHash = Hashing.sha256()
        .hashString(password, StandardCharsets.UTF_8)
        .toString();
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

  public String getUsername() {
    return username;
  }

  public String getPasswordHash() {
    return passwordHash;
  }
}
