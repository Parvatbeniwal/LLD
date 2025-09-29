package com.lld1.user;

import com.lld1.inventory.Book;

public class Librarian extends User {
/*
Task 5: Create a Subclass Librarian
Objective: Implement additional subclass-specific functionality.

Step 5.1: Create a subclass Librarian that extends User.
Step 5.2: Add the private attribute String employeeNumber.

Step 5.3: Override the abstract methods:
displayDashboard() should display Librarian Dashboard and the employeeNumber.
canBorrowBooks() should always return true.

Step 5.4: Add methods for librarian-specific actions:
void addNewBook(Book book)
void removeBook(Book book)
Leave implementations as comments for now.
* */

    private int employeeNumber;

    @Override
    public void displayDashboard() {
        System.out.println("Librarian Board" + this.employeeNumber);
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    public void addNewBook(Book book){

    }

    public void removeBook(Book book){

    }
}
