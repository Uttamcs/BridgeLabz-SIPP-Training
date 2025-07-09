package LinkedList;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = true;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    private Book head;
    private Book tail;

    public void addBook(String title, String author, String genre, int bookId) {
        Book newBook = new Book(title, author, genre, bookId);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void removeBook(int bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public Book searchByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equals(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateAvailability(int bookId, boolean isAvailable) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        Book current = head;
        while (current != null) {
            System.out.println("ID: " + current.bookId + ", Title: " + current.title + 
                             ", Author: " + current.author + ", Genre: " + current.genre + 
                             ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println("ID: " + current.bookId + ", Title: " + current.title + 
                             ", Author: " + current.author + ", Genre: " + current.genre + 
                             ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        
        library.addBook("1984", "George Orwell", "Dystopian", 1);
        library.addBook("To Kill a Mockingbird", "Harper Lee", "Fiction", 2);
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 3);
        
        System.out.println("Library Books (Forward):");
        library.displayForward();
        
        System.out.println("\nTotal Books: " + library.countBooks());
        
        library.updateAvailability(2, false);
        System.out.println("\nAfter checking out 'To Kill a Mockingbird':");
        library.displayForward();
        
        System.out.println("\nLibrary Books (Reverse):");
        library.displayReverse();
    }
}