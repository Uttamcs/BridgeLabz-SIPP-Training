package WorkShop;
import java.util.*;

public class BookBuddy {
    private ArrayList<String> bookShelf;
    BookBuddy() {
        bookShelf = new ArrayList<String>();
    }

    public void addBook(String title, String author) {
        bookShelf.add(title + "-" + author);
    }

    void sortBooksAlphabeticallly() {
        int n = bookShelf.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String title1 = bookShelf.get(j).split("-")[0];
                String title2 = bookShelf.get(j + 1).split("-")[0];
                if (title1.compareToIgnoreCase(title2) > 0) {
                    String temp = bookShelf.get(j);
                    bookShelf.set(j, bookShelf.get(j + 1));
                    bookShelf.set(j + 1, temp);
                }
            }
        }
    }

    ArrayList<String> searchByAuthor(String author) {
        ArrayList<String> res = new ArrayList<>();
        for (String book : bookShelf) {
            if (book.split("-")[1].equalsIgnoreCase(author)) {
                res.add(book);
            }
        }
        return res;
    }

    public String[] exportBooks() {
        return bookShelf.toArray(new String[0]);
    }

    public static void main(String[] args) {
        BookBuddy obj = new BookBuddy();
        obj.addBook("Java", "James Gosling");
        obj.addBook("C++", "Bjarne Stroustrup");
        obj.addBook("Ramayan", "Mahrishi Balmiki");
        obj.addBook("Mahabharat", "Ved Vyas");
        obj.sortBooksAlphabeticallly();
        System.out.println(Arrays.toString(obj.exportBooks()));
        System.out.println(obj.searchByAuthor("Ved Vyas"));
    }
}
