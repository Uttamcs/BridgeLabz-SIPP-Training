import java.util.ArrayList;

class Book {
    String title;
    String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    String name;
    ArrayList<Book> books;
    
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.displayDetails();
        }
    }
}

public class LibraryAndBooks {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "Sameer kushwaha");
        Book book2 = new Book("Data Structures", "Sandy Bhai");
        
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("Departmental Library");
        
        lib1.addBook(book1);
        lib1.addBook(book2);
        lib2.addBook(book1);
        
        lib1.displayBooks();
        lib2.displayBooks();
    }
}