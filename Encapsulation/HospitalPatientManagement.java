interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    protected String getDiagnosis() { return diagnosis; }
    protected void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    
    public abstract double calculateBill();
    
    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private String medicalHistory;
    
    public InPatient(int patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.medicalHistory = "";
    }
    
    @Override
    public double calculateBill() {
        return daysAdmitted * 500;
    }
    
    @Override
    public void addRecord(String record) {
        medicalHistory += record + "; ";
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical History: " + medicalHistory);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private int consultationFee;
    private String medicalHistory;
    
    public OutPatient(int patientId, String name, int age, int consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = "";
    }
    
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    
    @Override
    public void addRecord(String record) {
        medicalHistory += record + "; ";
    }
    
    @Override
    public void viewRecords() {
        System.out.println("Medical History: " + medicalHistory);
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient(101, "Alice", 30, 5),
            new OutPatient(102, "Bob", 45, 100)
        };
        
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Bill: $" + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).addRecord("Routine checkup");
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println();
        }
    }
}