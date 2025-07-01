import java.util.ArrayList;

class Patient {
    String name;
    int age;
    String ailment;
    
    public Patient(String name, int age, String ailment) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }
    
    public void displayDetails() {
        System.out.println("Patient: " + name + ", Age: " + age + ", Ailment: " + ailment);
    }
}

class Doctor {
    String name;
    String specialization;
    ArrayList<Patient> patients;
    
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }
    
    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " is consulting " + patient.name + " for " + patient.ailment);
    }
    
    public void displayPatients() {
        System.out.println("Dr. " + name + " (" + specialization + ")");
        for (Patient patient : patients) {
            patient.displayDetails();
        }
    }
}

class Hospital {
    String hospitalName;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;
    
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    
    public void displayHospital() {
        System.out.println("Hospital: " + hospitalName);
        for (Doctor doctor : doctors) {
            doctor.displayPatients();
        }
    }
}

public class HospitalDoctorsPatients {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        
        Doctor d1 = new Doctor("Smith", "Cardiologist");
        Doctor d2 = new Doctor("Johnson", "Neurologist");
        
        Patient p1 = new Patient("Alice", 30, "Heart Disease");
        Patient p2 = new Patient("Bob", 45, "Headache");
        Patient p3 = new Patient("Carol", 25, "Chest Pain");
        
        d1.consult(p1);
        d1.consult(p3);
        d2.consult(p2);
        
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);
        hospital.addPatient(p3);
        
        hospital.displayHospital();
    }
}