class Device {
    String deviceId;
    boolean status;
    
    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + (status ? "ON" : "OFF"));
    }
}

class Thermostat extends Device {
    int temperatureSetting;
    
    public Thermostat(String deviceId, boolean status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHomeDevices {
    public static void main(String[] args) {
        Device device1 = new Device("DEV001", true);
        Thermostat thermostat1 = new Thermostat("THERM001", true, 22);
        Thermostat thermostat2 = new Thermostat("THERM002", false, 18);
        
        device1.displayStatus();
        System.out.println();
        
        thermostat1.displayStatus();
        System.out.println();
        
        thermostat2.displayStatus();
    }
}