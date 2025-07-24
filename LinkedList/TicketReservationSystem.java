package LinkedList;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) return;
        
        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            return;
        }
        
        Ticket temp = head;
        if (head.ticketId == ticketId) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            return;
        }
        
        while (temp.next != head && temp.next.ticketId != ticketId) {
            temp = temp.next;
        }
        if (temp.next.ticketId == ticketId) {
            temp.next = temp.next.next;
        }
    }

    public Ticket searchByCustomer(String customerName) {
        if (head == null) return null;
        Ticket temp = head;
        do {
            if (temp.customerName.equals(customerName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public Ticket searchByMovie(String movieName) {
        if (head == null) return null;
        Ticket temp = head;
        do {
            if (temp.movieName.equals(movieName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public int getTotalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + 
                             ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + 
                             ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        
        system.addTicket(1, "John Doe", "Avengers", "A1", "2024-01-15 18:00");
        system.addTicket(2, "Jane Smith", "Spider-Man", "B5", "2024-01-15 20:00");
        system.addTicket(3, "Bob Johnson", "Avengers", "A2", "2024-01-15 18:00");
        
        System.out.println("All Tickets:");
        system.displayAllTickets();
        
        System.out.println("\nTotal Tickets: " + system.getTotalTickets());
        
        Ticket found = system.searchByCustomer("Jane Smith");
        if (found != null) {
            System.out.println("Found ticket for Jane Smith: " + found.movieName + " at " + found.seatNumber);
        }
        
        system.removeTicket(2);
        System.out.println("\nAfter removing ticket 2:");
        system.displayAllTickets();
    }
}