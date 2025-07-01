public class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "Not Assigned";
        this.price = 0.0;
    }
    
    public void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }
    
    public void displayTicketDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
    }
    
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Avengers");
        MovieTicket ticket2 = new MovieTicket("Spider-Man");
        
        ticket1.bookTicket("A15", 12.50);
        ticket1.displayTicketDetails();
        System.out.println();
        
        ticket2.bookTicket("B20", 15.00);
        ticket2.displayTicketDetails();
    }
}