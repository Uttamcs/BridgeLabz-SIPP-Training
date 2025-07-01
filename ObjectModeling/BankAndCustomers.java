import java.util.ArrayList;

class Customer {
    String name;
    String accountNumber;
    double balance;
    
    public Customer(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void viewBalance() {
        System.out.println("Customer: " + name + ", Balance: $" + balance);
    }
}

class Bank {
    String bankName;
    ArrayList<Customer> customers;
    
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }
    
    public void openAccount(Customer customer) {
        customers.add(customer);
        System.out.println("Account opened for " + customer.name + " at " + bankName);
    }
    
    public void displayCustomers() {
        System.out.println("Bank: " + bankName);
        for (Customer customer : customers) {
            customer.viewBalance();
        }
    }
}

public class BankAndCustomers {
    public static void main(String[] args) {
        Bank bank = new Bank("GLA Bank");
        
        Customer c1 = new Customer("Suraj Sharma", "ACC001", 5000);
        Customer c2 = new Customer("Manish Jaat", "ACC002", 7500);
        
        bank.openAccount(c1);
        bank.openAccount(c2);
        
        bank.displayCustomers();
    }
}