package Collections;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, 
                 String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }
    
    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
    
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    
    @Override
    public String toString() {
        return "Policy [number=" + policyNumber + ", holder=" + policyholderName + 
               ", expiry=" + expiryDate + ", coverage=" + coverageType + 
               ", premium=$" + premiumAmount + "]";
    }
}

public class InsurancePolicySetSystem {
    private Set<Policy> policyHashSet = new HashSet<>();
    private Set<Policy> policyLinkedHashSet = new LinkedHashSet<>();
    private Set<Policy> policyTreeSet = new TreeSet<>();
    
    public void addPolicy(Policy policy) {
        policyHashSet.add(policy);
        policyLinkedHashSet.add(policy);
        policyTreeSet.add(policy);
    }
    
    public Set<Policy> getAllPolicies() {
        return policyHashSet;
    }
    
    public Set<Policy> getPoliciesExpiringWithin(int days) {
        Set<Policy> expiringPolicies = new HashSet<>();
        LocalDate today = LocalDate.now();
        LocalDate cutoff = today.plusDays(days);
        
        for (Policy policy : policyHashSet) {
            if (policy.getExpiryDate().isAfter(today) && 
                policy.getExpiryDate().isBefore(cutoff) || 
                policy.getExpiryDate().isEqual(cutoff)) {
                expiringPolicies.add(policy);
            }
        }
        
        return expiringPolicies;
    }
    
    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        Set<Policy> matchingPolicies = new HashSet<>();
        
        for (Policy policy : policyHashSet) {
            if (policy.getCoverageType().equals(coverageType)) {
                matchingPolicies.add(policy);
            }
        }
        
        return matchingPolicies;
    }
    
    public static void main(String[] args) {
        InsurancePolicySetSystem system = new InsurancePolicySetSystem();
        
        system.addPolicy(new Policy("P001", "John Doe", LocalDate.now().plusDays(15), 
                                   "Health", 1200.0));
        system.addPolicy(new Policy("P002", "Jane Smith", LocalDate.now().plusDays(45), 
                                   "Auto", 800.0));
        system.addPolicy(new Policy("P003", "Bob Johnson", LocalDate.now().plusDays(10), 
                                   "Home", 1500.0));
        system.addPolicy(new Policy("P004", "Alice Brown", LocalDate.now().plusDays(60), 
                                   "Health", 950.0));
        
        System.out.println("All Policies:");
        for (Policy policy : system.getAllPolicies()) {
            System.out.println(policy);
        }
        
        System.out.println("\nPolicies Expiring in 30 Days:");
        for (Policy policy : system.getPoliciesExpiringWithin(30)) {
            System.out.println(policy);
        }
        
        System.out.println("\nHealth Policies:");
        for (Policy policy : system.getPoliciesByCoverageType("Health")) {
            System.out.println(policy);
        }
        
        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");
        for (Policy policy : system.policyTreeSet) {
            System.out.println(policy);
        }
    }
}