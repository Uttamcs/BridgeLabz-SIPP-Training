package Collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class WithdrawalRequest {
    private String accountNumber;
    private double amount;
    
    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    
    public String getAccountNumber() { return accountNumber; }
    public double getAmount() { return amount; }
    
    @Override
    public String toString() {
        return "Withdrawal: Account " + accountNumber + ", Amount: $" + amount;
    }
}

public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();
    
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }
    
    public double getBalance(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found");
        }
        return accounts.get(accountNumber);
    }
    
    public void deposit(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found");
        }
        
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        
        accounts.put(accountNumber, accounts.get(accountNumber) + amount);
    }
    
    public void requestWithdrawal(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found");
        }
        
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }
    
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            String accountNumber = request.getAccountNumber();
            double amount = request.getAmount();
            
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Processed: " + request);
            } else {
                System.out.println("Insufficient funds for: " + request);
            }
        }
    }
    
    public Map<Double, String> getAccountsSortedByBalance() {
        Map<Double, String> sortedAccounts = new TreeMap<>((a, b) -> Double.compare(b, a));
        
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }
        
        return sortedAccounts;
    }
    
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        // Create accounts
        bank.createAccount("A001", 1000.0);
        bank.createAccount("A002", 2500.0);
        bank.createAccount("A003", 500.0);
        
        // Make deposits
        bank.deposit("A001", 500.0);
        bank.deposit("A003", 300.0);
        
        // Request withdrawals
        bank.requestWithdrawal("A001", 200.0);
        bank.requestWithdrawal("A002", 1000.0);
        bank.requestWithdrawal("A003", 900.0);
        
        System.out.println("Processing withdrawals...");
        bank.processWithdrawals();
        
        System.out.println("\nAccounts sorted by balance (highest first):");
        for (Map.Entry<Double, String> entry : bank.getAccountsSortedByBalance().entrySet()) {
            System.out.println("Account " + entry.getValue() + ": $" + entry.getKey());
        }
    }
}