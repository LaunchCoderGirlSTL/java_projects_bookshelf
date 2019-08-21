package org.codergirl.java.bookshelf.dao;

import org.codergirl.java.bookshelf.models.Bookmark;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookmarksRowMapper {

    public Bookmark mapRow(ResultSet resultSet, int ignoreThis) {
        int id;
        String title;
        String address;

        /* Replace these temporary bindings by requesting
         * columns from resultSet
         * */
        id = 3;
        title = "Title";
        address = "Some Address";
        /*
        Replacement bindings go above
         */

        return new Bookmark(id, title, address);
    }
}
