package org.codergirl.java.bookshelf.models;

public class Bookmark {
    private String title;
    private String webAddress;

    public Bookmark(String title, String webAddress) {
        this.title = title;
        this.webAddress = webAddress;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getWebAddress() {
        return webAddress;
    }
}
