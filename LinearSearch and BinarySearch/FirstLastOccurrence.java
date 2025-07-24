package BinarySearch;

public class FirstLastOccurrence {
    public static int[] searchRange(int[] nums, int tgt) {
        int[] res = {-1, -1};
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] == tgt) {
                res[0] = m;
                r = m - 1;
            } else if (nums[m] < tgt) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        if (res[0] == -1) {
            return res;
        }
        
        l = 0;
        r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] == tgt) {
                res[1] = m;
                l = m + 1;
            } else if (nums[m] < tgt) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int tgt = 8;
        
        int[] res = searchRange(nums, tgt);
        
        System.out.println("First occurrence of " + tgt + " is at index: " + res[0]);
        System.out.println("Last occurrence of " + tgt + " is at index: " + res[1]);
    }
}