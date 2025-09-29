package com.lld1.management;

import com.lld1.user.User;

public interface Lendable {

    boolean lend(User user);

    void returnBook(User user);

    boolean isAvailable();
}
