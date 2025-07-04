interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public boolean isAvailable() { return isAvailable; }
    protected void setAvailable(boolean available) { this.isAvailable = available; }
    
    public abstract int getLoanDuration();
    
    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

class Book extends LibraryItem implements Reservable {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 14;
    }
    
    @Override
    public void reserveItem(String borrower) {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println("Book reserved for " + borrower);
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 7;
    }
    
    @Override
    public void reserveItem(String borrower) {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println("Magazine reserved for " + borrower);
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 3;
    }
    
    @Override
    public void reserveItem(String borrower) {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println("DVD reserved for " + borrower);
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book(1, "Java Programming", "John Doe"),
            new Magazine(2, "Tech Today", "Jane Smith"),
            new DVD(3, "Learning Java", "Bob Wilson")
        };
        
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            System.out.println();
        }
    }
}