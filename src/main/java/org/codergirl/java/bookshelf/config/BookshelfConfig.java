package org.codergirl.java.bookshelf.config;

import org.codergirl.java.bookshelf.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class BookshelfConfig {

  // https://www.baeldung.com/spring-mvc-session-attributes

  @Bean
  @Scope(
      value = WebApplicationContext.SCOPE_SESSION,
      proxyMode = ScopedProxyMode.TARGET_CLASS)
  public User user() {
    return new User();
  }
}
