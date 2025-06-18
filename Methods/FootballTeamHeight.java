public class FootballTeamHeight {
    public static void main(String[] args) {
        int[] heights = new int[11];
        
        // Generate random heights between 150cm and 250cm
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int)(Math.random() * 101);
        }
        
        System.out.println("Player heights (in cm):");
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + heights[i]);
        }
        
        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);
        
        System.out.println("\nStatistics:");
        System.out.println("Sum of heights: " + sum + " cm");
        System.out.printf("Mean height: %.2f cm\n", mean);
        System.out.println("Shortest player: " + shortest + " cm");
        System.out.println("Tallest player: " + tallest + " cm");
    }
    
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
    
    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }
    
    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }
    
    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }
}