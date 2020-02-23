/*
 * User.java
 *
 * Project: Bomberman
 *
 * Team: Application Highscore
 *
 * Copyright (C) Team Application Highscore
 */
package ch.gibb.bomberman.component.highscore.models;

import javax.persistence.*;

/**
 * The hibernate entity.
 *
 * @author Thomas Pauli, www.thomaspauli.ch
 * @since 0.0.1
 */
@NamedQueries({
        @NamedQuery(
                name = User.FIND_BY_ID,
                query = "select user from User user where user.id = :id"),
        @NamedQuery(
                name = User.FIND_BY_USERNAME,
                query = "select user from User user where user.username = :username"),
        @NamedQuery(
                name = User.GELL_ALL,
                query = "select user from User user")})
@Entity
@Table(name = "users")
public class User {

    public static final String FIND_BY_ID = "findUserById";
    public static final String FIND_BY_USERNAME = "findUserByUsername";
    public static final String GELL_ALL = "getAllUsers";

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = true, length = 100, unique = true)
    private String username;

    @Column(nullable = true)
    private int highScore;

    public User(){}

    public User(String username, int highScore) {
        this.username = username;
        this.highScore = highScore;
    }

    public User(int id, String username, int highScore) {
        this.id = id;
        this.username = username;
        this.highScore = highScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}

