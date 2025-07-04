package WorkShop;

import java.util.*;

public class FlightBookingSystem {

    static String[] availableFlights = {
        "DELHI to MUMBAI",
        "MUMBAI to CHENNAI",
        "BANGALORE to DELHI",
        "KOLKATA to MUMBAI",
        "DELHI to GOA"
    };

    static List<String> userBookings = new ArrayList<>();

    public static void searchFlights(String keyword) {
        System.out.println("\nSearch Results:");
        boolean found = false;
        keyword = keyword.toLowerCase();

        for (String flight : availableFlights) {
            if (flight.toLowerCase().contains(keyword)) {
                System.out.println("- " + flight);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No flights found for: " + keyword);
        }
    }

    public static void bookFlight(String flightName) {
        for (String flight : availableFlights) {
            if (flight.equalsIgnoreCase(flightName)) {
                userBookings.add(flight);
                System.out.println("Flight booked successfully: " + flight);
                return;
            }
        }
        System.out.println("Flight not found. Please check the name and try again.");
    }

    public static void displayBookings() {
        System.out.println("\nYour Bookings:");
        if (userBookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (String booking : userBookings) {
                System.out.println("- " + booking);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Search Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. View My Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter keyword to search flights: ");
                    String keyword = sc.nextLine();
                    searchFlights(keyword);
                    break;

                case 2:
                    System.out.print("Enter the exact flight name to book: ");
                    String flightName = sc.nextLine();
                    bookFlight(flightName);
                    break;

                case 3:
                    displayBookings();
                    break;

                case 4:
                    System.out.println("Thank you for using the Flight Booking System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

    }
}
