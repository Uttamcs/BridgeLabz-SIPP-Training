public class BankAccountSystem {
    static String bankName = "Apka Apna Bank";
    static int totalAccounts = 0;
    
    String accountHolderName;
    final String accountNumber;
    double balance;
    
    public BankAccountSystem(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    
    public static void main(String[] args) {
        BankAccountSystem acc1 = new BankAccountSystem("Ram", "ACC001", 5000);
        BankAccountSystem acc2 = new BankAccountSystem("Raju", "ACC002", 7500);
        
        Object obj = acc1;
        if (obj instanceof BankAccountSystem) {
            ((BankAccountSystem) obj).displayDetails();
        }
        
        System.out.println("Total Accounts: " + BankAccountSystem.getTotalAccounts());
    }
}