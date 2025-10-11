package com.lld1.library.user;

public class Member extends User {
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
