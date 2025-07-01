public class Book {
    public String ISBN;
    protected String title;
    private String author;
    
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void displayDetails() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Author: " + author);
    }
}

class EBook extends Book {
    double fileSize;
    
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }
    
    public void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Author: " + getAuthor() + ", File Size: " + fileSize + "MB");
    }
    
    public static void main(String[] args) {
        Book b1 = new Book("978-123456789", "Java Programming", "John Smith");
        EBook eb1 = new EBook("978-987654321", "Digital Marketing", "Jane Doe", 15.5);
        
        b1.displayDetails();
        eb1.displayEBookDetails();
        
        b1.setAuthor("John Smith Jr.");
        System.out.println("Updated Author: " + b1.getAuthor());
    }
}