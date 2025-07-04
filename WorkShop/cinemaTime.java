import java.util.*;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

public class cinemaTime {

    private List<String> movieTitles;
    private List<String> movieTimes;

    public cinemaTime() {
        movieTitles = new ArrayList<>();
        movieTimes = new ArrayList<>();
    }

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTimeFormat(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        movieTimes.add(time);
        System.out.println("Added: " + title + " at " + time);
    }

    private boolean isValidTimeFormat(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) {
            return false;
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    }

    public void searchMovie(String keyword) {
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(String.format("Found: %s at %s", movieTitles.get(i), movieTimes.get(i)));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movie found with keyword: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error while searching movies: " + e.getMessage());
        }
    }

    public void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }

        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println((i + 1) + ". " + movieTitles.get(i) + " at " + movieTimes.get(i));
        }
    }

    public void printMovieReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = movieTimes.toArray(new String[0]);

        System.out.println("\n--- Movie Report (Array Format) ---");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println("Movie: " + titlesArray[i] + " | Showtime: " + timesArray[i]);
        }
    }

    public static void main(String[] args) {
        cinemaTime manager = new cinemaTime();

        try {
            manager.addMovie("The Matrix", "19:30");
            manager.addMovie("Inception", "21:15");
            manager.addMovie("BadTime", "25:99"); 
        } catch (InvalidTimeFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        manager.displayAllMovies();
        manager.searchMovie("matrix");
        manager.printMovieReport();
    }
}
