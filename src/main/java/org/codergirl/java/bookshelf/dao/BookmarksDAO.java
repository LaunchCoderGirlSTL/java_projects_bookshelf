package org.codergirl.java.bookshelf.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookmarksDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
}
