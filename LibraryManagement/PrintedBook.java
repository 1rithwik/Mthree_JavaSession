// PrintedBook class extends Book
package LibraryManagement;

public class PrintedBook extends Book {
    private String shelfLocation;

    public PrintedBook(String bookId, String title, String author, String isbn, String shelfLocation) {
        super(bookId, title, author, isbn);
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    // Overriding the borrowBook method to add specific details for Printed Books
    @Override
    public void borrowBook() {
        if (isAvailable()) {
            System.out.println("You borrowed the printed book: " + getTitle() + ". Find it on shelf: " + shelfLocation);
        } else {
            System.out.println("Printed book is currently unavailable.");
        }
    }
}
