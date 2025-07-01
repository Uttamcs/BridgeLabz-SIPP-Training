public class HospitalManagementSystem{
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    
    String name;
    int age;
    String ailment;
    final int patientID;
    
    public HospitalManagementSystem(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }
    
    public static int getTotalPatients() {
        return totalPatients;
    }
    
    public void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
    
    public static void main(String[] args) {
        HospitalManagementSystem p1 = new HospitalManagementSystem("Elvish Yadav", 30, "Fever", 1001);
        HospitalManagementSystem p2 = new HospitalManagementSystem("Abhishek Yadav", 45, "Headache", 1002);
        
        Object obj = p1;
        if (obj instanceof HospitalManagementSystem) {
            ((HospitalManagementSystem) obj).displayDetails();
        }
        
        System.out.println("Total Patients: " + HospitalManagementSystem.getTotalPatients());
    }
}