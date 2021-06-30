package com.enoch.shoppersparadise.model;

public class User {
    int UserId;
    String UserName;
    String fullName;
    String password;
    String email;
    
    public User() {
    }

    public User(int userId, String userName, String fullName, String password, String email) {
        UserId = userId;
        UserName = userName;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
