package org.codergirl.java.bookshelf.dao;

import org.codergirl.java.bookshelf.models.Bookmark;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookmarksRowMapper implements RowMapper<Bookmark> {

    public Bookmark mapRow(ResultSet resultSet, int ignoreThis) throws SQLException {
        int id;
        String title;
        String address;

        id = resultSet.getInt("id");
        title = resultSet.getString("title");
        address = resultSet.getString("address");

        return new Bookmark(id, title, address);
    }
}
