package org.codergirl.java.bookshelf.dao;

import org.codergirl.java.bookshelf.models.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookmarksDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Bookmark> getAll() {

        return jdbcTemplate.query("select * from bookshelf.bookmark",
                new BookmarksRowMapper());
    }

    public void addBookmark(Bookmark bookmark){
        System.out.println("Inserting " + bookmark);
        jdbcTemplate.update(
                "INSERT INTO bookshelf.bookmark(title, address) VALUES (?,?)",
                bookmark.getTitle(), bookmark.getWebAddress());
    }

    public void updateBookmark(int id, Bookmark bookmark){
        System.out.println("Updating " + bookmark);
        jdbcTemplate.update(
                "UPDATE bookshelf.bookmark SET title=?, address=? where id=?",
                bookmark.getTitle(), bookmark.getWebAddress(), id);
    }

    public Bookmark findById(int id){
        List<Bookmark> matches = jdbcTemplate.query(
                "select * from bookshelf.bookmark where id = ?",
                new Object[] { id },
                new BookmarksRowMapper());
        if (matches.isEmpty()){
            return null;
        }
        else {
            return matches.get(0);
        }
    }
}
