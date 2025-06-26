

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0261103344");
        Book book2 = new Book("1984", "George Orwell", "978-0451524935");
        Book book3 = new Book("Clean Code", "Robert C. Martin", "978-0132350884");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        User user1 = new User("Alice", 1);
        User user2 = new User("Bob", 2);

        library.displayBooks();

        library.issueBook("978-0451524935", user1);
        library.issueBook("978-0451524935", user2);

        library.displayBooks();

        library.returnBook("978-0451524935", user1);

        library.displayBooks();
    }
}