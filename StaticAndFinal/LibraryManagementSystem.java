public class LibraryManagementSystem {
    static String libraryName = "Central Library, GLA University";
    
    String title;
    String author;
    final String isbn;
    
    public LibraryManagementSystem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }
    
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
    
    public static void main(String[] args) {
        LibraryManagementSystem book1 = new LibraryManagementSystem("Java Programming", "John Smith", "978-123456789");
        LibraryManagementSystem book2 = new LibraryManagementSystem("Data Structures", "Jane Doe", "978-987654321");
        
        LibraryManagementSystem.displayLibraryName();
        
        Object obj = book1;
        if (obj instanceof LibraryManagementSystem) {
            ((LibraryManagementSystem) obj).displayDetails();
        }
    }
}