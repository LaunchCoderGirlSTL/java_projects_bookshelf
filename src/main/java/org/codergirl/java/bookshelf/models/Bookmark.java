package org.codergirl.java.bookshelf.models;

public class Bookmark {
    private String title;

    public Bookmark(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }
}
