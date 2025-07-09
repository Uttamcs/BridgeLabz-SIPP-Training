package LinkedList;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagementSystem {
    private Movie head;
    private Movie tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
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

    public Movie searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + 
                             ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public void displayReverse() {
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + 
                             ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();
        
        system.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        system.addAtEnd("The Matrix", "Wachowski Sisters", 1999, 8.7);
        system.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.6);
        
        System.out.println("Movies (Forward):");
        system.displayForward();
        
        System.out.println("\nMovies (Reverse):");
        system.displayReverse();
        
        system.updateRating("Inception", 9.0);
        System.out.println("\nAfter updating Inception rating:");
        system.displayForward();
    }
}