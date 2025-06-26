
import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayDetails();
}

public class Book extends LibraryItem {
    private String author;
    private String isbn;
    private boolean isIssued = false;

    public Book(String title, String author, String isbn) {
        super(title);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + getTitle() + ", Author: " + author + ", ISBN: " + isbn + ", Issued: " + isIssued);
    }
}


class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean issueBook(String isbn, User user) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isIssued()) {
                book.setIssued(true);
                System.out.println("Book issued to " + user.getName());
                return true;
            }
        }
        System.out.println("Book not available for issue.");
        return false;
    }
    public boolean returnBook(String isbn, User user) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isIssued()) {
                book.setIssued(false);
                System.out.println("Book returned by " + user.getName());
                return true;
            }
        }
        System.out.println("Book was not issued.");
        return false;
    }

    public void displayBooks() {
        for (Book book : books) {
            book.displayDetails();
        }
    }
}