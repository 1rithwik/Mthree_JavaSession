package LibraryManagement;

import java.time.LocalDate;
import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // methods to add, remove, and find books
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getIsbn().equals(book.getIsbn())) {
                System.out.println("Book with the same ISBN already exists.");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public boolean removeBook(String isbn) {
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove(); // Remove book from the collection
                return true; // Successfully removed
            }
        }
        return false; // Book not found
    }

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // Return null if the book is not found
    }

    // methods to add, remove, and find users
    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(String userId) {
        if (users.contains(userId)) {
            users.remove(userId);
        } else {
            System.out.println("User not found in the library.");
        }
    }

    public User findUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        return books; // Return the list of books
    }

    private List<Transaction> transactions = new ArrayList<>();

    public void borrowBook(User user, String isbn) {
        Book book = findBook(isbn);
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            Transaction transaction = new Transaction("T" + (transactions.size() + 1), user.getUserId(),
                    book.getBookId(), LocalDate.now());
            transactions.add(transaction);
            System.out.println(user.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not found or unavailable.");
        }
    }

    public void returnBook(User user, String isbn) {
        Book book = findBook(isbn);
        if (book != null) {
            book.returnBook();
            for (Transaction transaction : transactions) {
                if (transaction.getBookId().equals(book.getBookId()) && transaction.getUserId().equals(user.getUserId())
                        && transaction.getReturnDate() == null) {
                    transaction.setReturnDate(LocalDate.now());
                    System.out.println(user.getName() + " returned: " + book.getTitle());
                    return;
                }
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public List<Book> searchBook(String query) {
        List<Book> matchingBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                    book.getIsbn().equals(query)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    public List<Book> listAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

}
