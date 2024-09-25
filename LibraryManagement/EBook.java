// EBook class extends Book
package LibraryManagement;

public class EBook extends Book {
    private String downloadLink;

    public EBook(String bookId, String title, String author, String isbn, String downloadLink) {
        super(bookId, title, author, isbn); // Call the parent constructor
        this.downloadLink = downloadLink;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    // Overriding the borrowBook method to show special behavior for EBooks
    @Override
    public void borrowBook() {
        if (isAvailable()) {
            System.out.println("You borrowed the eBook: " + getTitle() + ". Download it here: " + downloadLink);
        } else {
            System.out.println("EBook is currently unavailable.");
        }
    }
}
