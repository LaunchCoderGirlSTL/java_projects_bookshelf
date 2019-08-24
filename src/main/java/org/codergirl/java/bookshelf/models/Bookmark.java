package org.codergirl.java.bookshelf.models;

public class Bookmark {
    private String title;
    private String webAddress;
    private int id;

    public Bookmark(int id, String title, String webAddress) {
        this.id = id;
        this.title = title;
        this.webAddress = webAddress;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "title='" + title + '\'' +
                ", webAddress='" + webAddress + '\'' +
                ", id=" + id +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public int getId() {
        return id;
    }
}
