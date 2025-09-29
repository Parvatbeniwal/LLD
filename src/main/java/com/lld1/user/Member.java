package com.lld1.user;

public class Member extends User {
/*
* Task 4: Create a Subclass Member
Objective: Implement inheritance and method overriding.
Step 4.1: Create a concrete subclass Member that extends User.

Step 4.2: Add the following private attributes:
int borrowedBooksCount
A constant MAX_BORROW_LIMIT = 5

Step 4.3: Override the abstract methods:
displayDashboard() should display Member Dashboard and Books Borrowed: X.
canBorrowBooks() should return true if borrowedBooksCount < MAX_BORROW_LIMIT.
*/

  /*

   * */

    private int borrowedBooksCount;
    private static Integer MAX_BORROW_LIMIT = 5;


    public Member(String name, String contactInfo, int borrowedBooksCount) {
        super(name, contactInfo);
        this.borrowedBooksCount = borrowedBooksCount;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Borrowed Books: " + borrowedBooksCount);
    }

    @Override
    public boolean canBorrowBooks() {
        return this.borrowedBooksCount < MAX_BORROW_LIMIT;
    }
}
