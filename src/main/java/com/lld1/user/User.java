package com.lld1.user;

public abstract class User {
    /*
Task 6: Demonstrate Static and Final Concepts
Objective: Understand static and final concepts with practical use.
Resource for Static : https://www.scaler.com/topics/static-keyword-in-java/
Resource for Final : https://www.scaler.com/topics/java/final-keyword-in-java/

Step 6.1: Add a static counter totalUsers and a method getTotalUsers() to track the total number of users.
Challenge: Use a static variable to maintain state across instances.
Step 6.2: Write a generateUniqueId() method to create unique user IDs. Mark this method as final to prevent overriding.
Step 6.3: Verify that:
The generateUniqueId method cannot be overridden in subclasses.
The totalUsers counter accurately tracks the number of users.

*/

    private static int totalUsers = 0;

 /*
Task 1:
Objective: Introduce abstract classes, encapsulation, and basic object-oriented principles.
Step 1.1: Define a class User with the following private attributes:
String userId
String name
String contactInfo

* Step 1.2: Add getter and setter methods for name and contactInfo.
Challenge: Use encapsulation by keeping attributes private and accessing them through getters/setters.
* */
private String userId;
private String name;
private String contactInfo;


/*
Task 2: Add Constructors to User
Objective: Explore constructors (default, parameterized, and copy).
Step 2.1: Implement:
A default constructor that initializes userId using generateUniqueId method (We can return 0 from this method for now )
A parameterized constructor that initializes name and contactInfo.
A copy constructor that copies attributes from another User.
Step 2.2: Test constructors by creating instances using all three constructors in a test class.
*/

    public User(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }



    public User() {
        this.userId = generateUniqueId();
    }

    public User(User user) {
        this.name = user.getName();
        this.contactInfo = user.getContactInfo();
    }

    /*
    Task 3: Make User an Abstract Class
    Objective: Understand the concept of abstract classes and polymorphism.
    Step 3.1: Mark User as abstract and declare the following abstract methods:
    void displayDashboard()
    boolean canBorrowBooks()
    Step 3.2: Explain why these methods are abstract and how they enable polymorphism.
    */

    public static int getTotalUsers(){
        return totalUsers;
    }

    public abstract void  displayDashboard();

    public abstract boolean canBorrowBooks();

    public final String generateUniqueId() {
        return "0";
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
