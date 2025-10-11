package com.lld1.library.inventory;

import com.lld1.library.management.Lendable;
import com.lld1.library.user.User;

public abstract class Book implements Lendable {
    private String isbn;
    private String title;
    private String author;
    boolean isAvailable;

    public abstract void displayBookDetails();

    @Override
    public boolean lend(User user) {
        if (isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public void returnBook(User user) {
      this.isAvailable = true;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
