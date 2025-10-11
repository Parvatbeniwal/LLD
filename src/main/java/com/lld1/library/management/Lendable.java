package com.lld1.library.management;

import com.lld1.library.user.User;

public interface Lendable {

    boolean lend(User user);

    void returnBook(User user);

    boolean isAvailable();
}
