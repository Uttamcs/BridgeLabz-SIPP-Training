class BankAccount {
    String accountNumber;
    double balance;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void displayAccountType() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;
    
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
        super.displayAccountType();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    @Override
    public void displayAccountType() {
        System.out.println("Checking Account");
        super.displayAccountType();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int maturityPeriod;
    
    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }
    
    @Override
    public void displayAccountType() {
        System.out.println("Fixed Deposit Account");
        super.displayAccountType();
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SAV001", 10000, 3.5),
            new CheckingAccount("CHK001", 5000, 1000),
            new FixedDepositAccount("FD001", 50000, 12)
        };
        
        for (BankAccount account : accounts) {
            account.displayAccountType();
            System.out.println();
        }
    }
}