public class OTPGenerator {
    public static void main(String[] args) {
        int[] otps = new int[10];
        
        System.out.println("Generating 10 OTPs:");
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        
        boolean areUnique = checkUnique(otps);
        System.out.println("\nAll OTPs are unique: " + areUnique);
    }
    
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000); // 6-digit number between 100000 and 999999
    }
    
    public static boolean checkUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}