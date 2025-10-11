Build a library system where:

1. The library can have Books, magazines and Journals.
2. Some types of items can be loaned and some are only for reading at library.
3. Users (Members : Students, Professors | Librarian) can borrow and return different types of Library items.
4. Books have categories (Fiction, Non-fiction, Academic).
5. A loan management system keeps track of issued books.
6. Implement features like late fees and borrowing limits.

### 

***Milestone A*** : Represent User structure

- #### **Create the Base `User` Class**

- #### **Add Constructors to `User`**

- #### **Create a Subclass `Member`**

- #### **Create a Subclass `Librarian`**

- #### **Implement** `generateUniqueId using` **Static and Final Concepts**

#### ---

#### **Task 1: Create the Base `User` Class**

#### **Objective:** Introduce abstract classes, encapsulation, and basic object-oriented principles.

1. #### **Step 1.1:** Define a class `User` with the following private attributes:

    * #### `String userId`

    * #### `String name`

    * #### `String contactInfo`

2. #### **Step 1.2:** Add getter and setter methods for `name` and `contactInfo`.

    * #### **Challenge:** Use encapsulation by keeping attributes private and accessing them through getters/setters.

#### 

#### **Task 2: Add Constructors to `User`**

#### **Objective:** Explore constructors (default, parameterized, and copy).

1. #### **Step 2.1:** Implement:

    * #### A **default constructor** that initializes `userId` using `generateUniqueId method` (We can return 0 from this method for now )

    * #### A **parameterized constructor** that initializes `name` and `contactInfo`.

    * #### A **copy constructor** that copies attributes from another `User`.

2. #### **Step 2.2:** Test constructors by creating instances using all three constructors in a test class.

#### **Task 3: Make `User` an Abstract Class**

#### **Objective:** Understand the concept of abstract classes and polymorphism.

1. #### **Step 3.1:** Mark `User` as `abstract` and declare the following abstract methods:

    * #### `void displayDashboard()`

    * #### `boolean canBorrowBooks()`

2. #### **Step 3.2:** Explain why these methods are abstract and how they enable polymorphism.



#### ---

#### **Task 4: Create a Subclass `Member`**

#### **Objective:** Implement inheritance and method overriding.

1. #### **Step 4.1:** Create a concrete subclass `Member` that extends `User`.

2. #### **Step 4.2:** Add the following private attributes:

    * #### `int borrowedBooksCount`

    * #### A constant `MAX_BORROW_LIMIT = 5`

3. #### **Step 4.3:** Override the abstract methods:

    * #### `displayDashboard()` should display `Member Dashboard` and `Books Borrowed: X`.

    * #### `canBorrowBooks()` should return `true` if `borrowedBooksCount < MAX_BORROW_LIMIT`.

4. #### **Step 4.4:** Add constructors to initialize `Member`.

#### ---

#### **Task 5: Create a Subclass `Librarian`**

#### **Objective:** Implement additional subclass-specific functionality.

1. #### **Step 5.1:** Create a subclass `Librarian` that extends `User`.

2. #### **Step 5.2:** Add the private attribute `String employeeNumber`.

3. #### **Step 5.3:** Override the abstract methods:

    * #### `displayDashboard()` should display `Librarian Dashboard` and the `employeeNumber`.

    * #### `canBorrowBooks()` should always return `true`.

4. #### **Step 5.4:** Add methods for librarian-specific actions:

    * #### `void addNewBook(Book book)`

    * #### `void removeBook(Book book)`

    * #### Leave implementations as comments for now.

#### ---

#### **Task 6: Demonstrate Static and Final Concepts**

#### **Objective:** Understand `static` and `final` concepts with practical use.

1. #### **Step 6.1:** Add a static counter `totalUsers` and a method `getTotalUsers()` to track the total number of users.

    * #### **Challenge:** Use a static variable to maintain state across instances.

2. #### **Step 6.2:** Write a `generateUniqueId()` method to create unique user IDs. Mark this method as `final` to prevent overriding.

3. #### **Step 6.3:** Verify that:

    * #### The `generateUniqueId` method cannot be overridden in subclasses.

    * #### The `totalUsers` counter accurately tracks the number of users.

#### ---

#### MileStone B

#### **Task 1: Create the `Lendable` Interface**

**Objective:** Introduce interfaces and compile-time polymorphism.

1. **Step 1.1:** Define the `Lendable` interface with the following methods:
    * `boolean lend(User user)`
    * `void returnBook(User user)`
    * `boolean isAvailable()`
2. **Step 1.2:** Explain the purpose of interfaces and how they enable **compile-time polymorphism**.
3. **Step 1.3:** Create a basic test class to simulate borrowing a book by defining a dummy class that implements `Lendable`.

---

#### **Task 2: Implement the Abstract `Book` Class**

**Objective:** Explore abstract classes, encapsulation, and method overriding.

1. **Step 2.1:** Create the `Book` class that implements `Lendable`. Add the following private attributes:
    * `String isbn`
    * `String title`
    * `String author`
    * `boolean isAvailable`
2. **Step 2.2:** Implement the methods from `Lendable`:
    * `lend(User user)`: If the book is available and the user can borrow, mark the book as unavailable and return `true`.
    * `returnBook(User user)`: Mark the book as available.
    * `isAvailable()`: Return the availability status.
3. **Step 2.3:** Explain why the class is abstract and add an abstract method `void displayBookDetails()`.

---

```
Setting up rsa key for git hub account

eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519_personal
ssh-add -l
```

