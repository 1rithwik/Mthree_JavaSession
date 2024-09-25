package LibraryManagement;

public abstract class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String bookId, String title, String author, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public abstract void borrowBook();

    public void returnBook() {
        isAvailable = true;
    }

}
