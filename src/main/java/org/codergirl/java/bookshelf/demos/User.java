package org.codergirl.java.bookshelf.demos;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String quest;
    private String favoriteColor;

    public User(String username, String password, String quest, String favoriteColor) {
        this.username = username;
        this.password = Sha256.to256(password);
        this.quest = quest;
        this.favoriteColor = favoriteColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(quest, user.quest) &&
                Objects.equals(favoriteColor, user.favoriteColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, quest, favoriteColor);
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getQuest() {
        return quest;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }
}
