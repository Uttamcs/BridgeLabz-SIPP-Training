public class VehicleRegistrationSystem{
    static double registrationFee = 500.0;
    
    String ownerName;
    String vehicleType;
    final String registrationNumber;
    
    public VehicleRegistrationSystem(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    
    public void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: $" + registrationFee);
    }
    
    public static void main(String[] args) {
        VehicleRegistrationSystem v1 = new VehicleRegistrationSystem("Sameer Kushwaha", "Car", "REG001");
        VehicleRegistrationSystem v2 = new VehicleRegistrationSystem("Ayesha Queen", "Motorcycle", "REG002");
        
        Object obj = v1;
        if (obj instanceof VehicleRegistrationSystem) {
            ((VehicleRegistrationSystem) obj).displayDetails();
        }
        
        VehicleRegistrationSystem.updateRegistrationFee(600.0);
        System.out.println("Updated registration fee: $" + VehicleRegistrationSystem.registrationFee);
    }
}