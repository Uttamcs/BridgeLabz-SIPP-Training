package BinarySearch;

public class PeakElementFinder {
    public static int findPeakElement(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 3, 5, 6, 4};
        int peak = findPeakElement(nums);
        
        System.out.println("Peak element index: " + peak);
        System.out.println("Peak element value: " + nums[peak]);
    }
}