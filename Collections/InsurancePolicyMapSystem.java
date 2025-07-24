package Collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    
    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, 
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
    public String toString() {
        return "Policy [number=" + policyNumber + ", holder=" + policyholderName + 
               ", expiry=" + expiryDate + ", coverage=" + coverageType + 
               ", premium=$" + premiumAmount + "]";
    }
}

public class InsurancePolicyMapSystem {
    private Map<String, InsurancePolicy> policyHashMap = new HashMap<>();
    private Map<String, InsurancePolicy> policyLinkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<InsurancePolicy>> policyTreeMap = new TreeMap<>();
    
    public void addPolicy(InsurancePolicy policy) {
        // Add to HashMap for quick lookups
        policyHashMap.put(policy.getPolicyNumber(), policy);
        
        // Add to LinkedHashMap to maintain insertion order
        policyLinkedHashMap.put(policy.getPolicyNumber(), policy);
        
        // Add to TreeMap for sorting by expiry date
        LocalDate expiryDate = policy.getExpiryDate();
        if (!policyTreeMap.containsKey(expiryDate)) {
            policyTreeMap.put(expiryDate, new ArrayList<>());
        }
        policyTreeMap.get(expiryDate).add(policy);
    }
    
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyHashMap.get(policyNumber);
    }
    
    public List<InsurancePolicy> getPoliciesExpiringWithin(int days) {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate cutoff = today.plusDays(days);
        
        for (InsurancePolicy policy : policyHashMap.values()) {
            if (policy.getExpiryDate().isAfter(today) && 
                policy.getExpiryDate().isBefore(cutoff) || 
                policy.getExpiryDate().isEqual(cutoff)) {
                expiringPolicies.add(policy);
            }
        }
        
        return expiringPolicies;
    }
    
    public List<InsurancePolicy> getPoliciesByPolicyholder(String policyholderName) {
        List<InsurancePolicy> holderPolicies = new ArrayList<>();
        
        for (InsurancePolicy policy : policyHashMap.values()) {
            if (policy.getPolicyholderName().equals(policyholderName)) {
                holderPolicies.add(policy);
            }
        }
        
        return holderPolicies;
    }
    
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        List<String> expiredPolicyNumbers = new ArrayList<>();
        
        for (InsurancePolicy policy : policyHashMap.values()) {
            if (policy.getExpiryDate().isBefore(today)) {
                expiredPolicyNumbers.add(policy.getPolicyNumber());
            }
        }
        
        for (String policyNumber : expiredPolicyNumbers) {
            InsurancePolicy policy = policyHashMap.get(policyNumber);
            policyHashMap.remove(policyNumber);
            policyLinkedHashMap.remove(policyNumber);
            policyTreeMap.get(policy.getExpiryDate()).remove(policy);
        }
    }
    
    public static void main(String[] args) {
        InsurancePolicyMapSystem system = new InsurancePolicyMapSystem();
        
        system.addPolicy(new InsurancePolicy("P001", "John Doe", LocalDate.now().plusDays(15), 
                                           "Health", 1200.0));
        system.addPolicy(new InsurancePolicy("P002", "Jane Smith", LocalDate.now().plusDays(45), 
                                           "Auto", 800.0));
        system.addPolicy(new InsurancePolicy("P003", "John Doe", LocalDate.now().plusDays(10), 
                                           "Home", 1500.0));
        system.addPolicy(new InsurancePolicy("P004", "Alice Brown", LocalDate.now().minusDays(5), 
                                           "Health", 950.0));
        
        System.out.println("Policy P002 Details:");
        System.out.println(system.getPolicyByNumber("P002"));
        
        System.out.println("\nPolicies Expiring in 30 Days:");
        for (InsurancePolicy policy : system.getPoliciesExpiringWithin(30)) {
            System.out.println(policy);
        }
        
        System.out.println("\nJohn Doe's Policies:");
        for (InsurancePolicy policy : system.getPoliciesByPolicyholder("John Doe")) {
            System.out.println(policy);
        }
        
        System.out.println("\nRemoving Expired Policies...");
        system.removeExpiredPolicies();
        
        System.out.println("\nAll Policies After Removal:");
        for (InsurancePolicy policy : system.policyHashMap.values()) {
            System.out.println(policy);
        }
    }
}