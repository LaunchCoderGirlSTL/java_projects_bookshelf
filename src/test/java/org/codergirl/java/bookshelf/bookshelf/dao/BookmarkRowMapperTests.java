package org.codergirl.java.bookshelf.bookshelf.dao;

import org.codergirl.java.bookshelf.dao.BookmarksRowMapper;
import org.codergirl.java.bookshelf.models.Bookmark;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookmarkRowMapperTests {

    @Test
    public void mapTheBookmark() throws SQLException {

        /* This is some code that simulates what happens when Java runs
           SQL code using JDBC. It's meant to simulate a database call
           that produces this:

           ID  	TITLE  	ADDRESS
           3	Title   Some Address
        */
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(3);
        when(rs.getString("title")).thenReturn("Title");
        when(rs.getString("address")).thenReturn("Some Address");

        //This is the call to the Row Mapper
        Bookmark mapped = new BookmarksRowMapper().mapRow(rs, 0);

        //Here, we check the result to see if it worked!
        Assert.assertEquals(3, mapped.getId());
        Assert.assertEquals("Title", mapped.getTitle());
        Assert.assertEquals("Some Address", mapped.getWebAddress());

    }
}
