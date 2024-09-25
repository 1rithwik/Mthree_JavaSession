package LibraryManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AppSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library library = new Library(); // Library instance created here

        // Sample data
        library.addBook(new EBook("1", "The Great Gatsby", "F. Scott Fitzgerald", "123456789", "www.downloadlink.com"));
        library.addBook(new PrintedBook("2", "1_9_8_4", "George Orwell", "987654321", "Shelf A3"));
        // Adding an eBook
        EBook ebook = new EBook("1", "Digital Fortress", "Dan Brown", "123456789", "www.downloadlink.com");
        library.addBook(ebook);
        // Adding a Printed Book
        PrintedBook printedBook = new PrintedBook("2", "Harry Potter", "J.K. Rowling", "987654321", "Shelf A3");
        library.addBook(printedBook);
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
                    System.out.print("Is it an eBook or a Printed Book? (e/p): ");
                    String type = sc.nextLine();
                    if (type.equalsIgnoreCase("e")) {
                        System.out.print("Enter download link: ");
                        String downloadLink = sc.nextLine();
                        Book newBook = new EBook(bookId, title, author, isbn, downloadLink);
                        library.addBook(newBook);
                    } else if (type.equalsIgnoreCase("p")) {
                        System.out.print("Enter shelf location: ");
                        String shelfLocation = sc.nextLine();
                        Book newBook = new PrintedBook(bookId, title, author, isbn, shelfLocation);
                        library.addBook(newBook);
                    }
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
