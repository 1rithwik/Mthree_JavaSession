package LibraryManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AppSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Library library = new Library();

        // User user1 = new User("1", "John Doe", "john.doe@example.com");
        // library.addUser(user1);

        // Book book1 = new Book("1", "The Great Gatsby", "F. Scott Fitzgerald");
        // Book book2 = new Book("2", "To Kill a Mockingbird", "Harper Lee");
        // library.addBook(book1);
        // library.addBook(book2);

        // // Borrow a book
        // LocalDate borrowDate = LocalDate.now();
        // Transaction transaction = new Transaction("T1", user1.getUserId(),
        // book1.getBookId(), borrowDate);
        // System.out.println("Book borrowed: " + book1.getTitle() + " by " +
        // user1.getName());

        // // Return a book
        // LocalDate returnDate = borrowDate.plusDays(14);
        // transaction.setReturnDate(returnDate);
        // System.out.println("Book returned: " + book1.getTitle() + " by " +
        // user1.getName());

        Library library = new Library(); // Library instance created here

        // Sample data
        library.addBook(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald", "123456789"));
        library.addBook(new Book("2", "1_9_8_4", "George Orwell", "987654321"));
        // Menu interaction
        System.out.println("Welcome to the Library Management System");
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add User");
            System.out.println("2. Add Book");
            System.out.println("3. View All Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search for a Book");
            System.out.println("7. Remove a Book");
            System.out.println("8. List Available Books");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter user ID: ");
                    String userId = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    User newUser = new User(userId, name, email);
                    library.addUser(newUser);
                    System.out.println("User added!");
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    Book newBook = new Book(bookId, title, author, isbn);
                    library.addBook(newBook);
                    System.out.println("Book added!");
                    break;

                case 3:
                    System.out.println("All Books:");
                    List<Book> books = library.getBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        for (Book book : books) {
                            System.out.println(
                                    book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter user ID: ");
                    String borrowUserId = sc.nextLine();
                    User user = library.findUser(borrowUserId); // Find the user
                    if (user != null) {
                        System.out.print("Enter ISBN of the book to borrow: ");
                        String borrowIsbn = sc.nextLine();
                        library.borrowBook(user, borrowIsbn);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter user ID: ");
                    String returnUserId = sc.nextLine();
                    User returnUser = library.findUser(returnUserId); // Find the user
                    if (returnUser != null) {
                        System.out.print("Enter ISBN of the book to return: ");
                        String returnIsbn = sc.nextLine();
                        library.returnBook(returnUser, returnIsbn);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter title or author to search: ");
                    System.out.print("Enter title, author, or ISBN to search: ");
                    String searchQuery = sc.nextLine();

                    List<Book> foundBooks = library.searchBook(searchQuery);

                    if (foundBooks.isEmpty()) {
                        System.out.println("No books found matching the query.");
                    } else {
                        System.out.println("Books found:");
                        for (Book book : foundBooks) {
                            System.out.println(
                                    book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String removeIsbn = sc.nextLine();

                    boolean successRemove = library.removeBook(removeIsbn);

                    if (successRemove) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 8:
                    System.out.println("Available Books:");
                    List<Book> availableBooks = library.listAvailableBooks();

                    if (availableBooks.isEmpty()) {
                        System.out.println("No books are currently available.");
                    } else {
                        System.out.println("Available Books:");
                        for (Book book : availableBooks) {
                            System.out.println(
                                    book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
                        }
                    }
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

}
