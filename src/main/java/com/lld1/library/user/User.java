package com.lld1.library.user;

public abstract class User {

    private static int totalUsers = 0;

    private String userId;
    private String name;
    private String contactInfo;

    public User() {
        this.userId = generateUniqueId();
    }

    public User(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    //copy constructor
    public User(User user) {
        this.name = user.getName();
        this.contactInfo = user.getContactInfo();
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public abstract void displayDashboard();

    public abstract boolean canBorrowBooks();

    public final String generateUniqueId() {
        return new Object().toString();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
