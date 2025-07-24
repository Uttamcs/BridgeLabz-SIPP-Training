package Collections;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;
    
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    
    public String getName() { return name; }
    public int getSeverity() { return severity; }
    
    @Override
    public int compareTo(Patient other) {
        return other.severity - this.severity;
    }
    
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    private PriorityQueue<Patient> patientQueue;
    
    public HospitalTriageSystem() {
        patientQueue = new PriorityQueue<>();
    }
    
    public void addPatient(String name, int severity) {
        patientQueue.add(new Patient(name, severity));
    }
    
    public Patient treatNextPatient() {
        return patientQueue.poll();
    }
    
    public boolean hasPatients() {
        return !patientQueue.isEmpty();
    }
    
    public static void main(String[] args) {
        HospitalTriageSystem hospital = new HospitalTriageSystem();
        
        hospital.addPatient("John", 3);
        hospital.addPatient("Alice", 5);
        hospital.addPatient("Bob", 2);
        
        System.out.println("Treating patients in order of severity:");
        while (hospital.hasPatients()) {
            Patient patient = hospital.treatNextPatient();
            System.out.println("Treating: " + patient);
        }
    }
}