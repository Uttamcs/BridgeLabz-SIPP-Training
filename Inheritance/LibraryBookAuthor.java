class Book {
    String title;
    int publicationYear;
    
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    
    public void displayInfo() {
        System.out.println("Title: " + title + ", Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;
    
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name + ", Bio: " + bio);
    }
}

public class LibraryBookAuthor {
    public static void main(String[] args) {
        Author author1 = new Author("Effective Java", 2017, "Joshua Bloch", "Software Engineer at Google");
        Author author2 = new Author("Clean Code", 2008, "Robert Martin", "Software Consultant");
        
        author1.displayInfo();
        System.out.println();
        author2.displayInfo();
    }
}