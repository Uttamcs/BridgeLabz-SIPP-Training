public class EarthVolumeCalculator{
    public static void main(String[] args) {
        int radius = 6378; 
        double pi = Math.PI;
        double volumeKm3 = (4.0 / 3.0) * pi * Math.pow(radius, 3);
        double volumeMiles3 = volumeKm3 * 0.239913; 
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
    }
}