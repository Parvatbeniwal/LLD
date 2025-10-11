package com.lld1.library.user;

import com.lld1.library.inventory.Book;

public class Librarian extends User {

    private int employeeNumber;

    @Override
    public void displayDashboard() {
        System.out.println("Librarian Board" + this.employeeNumber);
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    public void addNewBook(Book book) {

    }

    public void removeBook(Book book) {

    }
}
