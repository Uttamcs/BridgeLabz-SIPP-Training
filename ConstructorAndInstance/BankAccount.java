public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void displayDetails() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;
    
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
    
    public void displaySavingsDetails() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: $" + getBalance() + ", Interest Rate: " + interestRate + "%");
    }
    
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount("ACC001", "Alice Johnson", 5000);
        SavingsAccount sa1 = new SavingsAccount("SAV001", "Bob Wilson", 10000, 3.5);
        
        ba1.displayDetails();
        sa1.displaySavingsDetails();
        
        ba1.setBalance(5500);
        System.out.println("Updated Balance: $" + ba1.getBalance());
    }
}