package BinarySearch;

import java.util.Arrays;

public class ChallengeSearchProblem {
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
    
    public static int binarySearch(int[] nums, int tgt) {
        Arrays.sort(nums);
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] == tgt) {
                return m;
            } else if (nums[m] < tgt) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 7, 2, -5, 8};
        int tgt = 7;
        
        int missing = findFirstMissingPositive(nums.clone());
        System.out.println("First missing positive integer: " + missing);
        
        int idx = binarySearch(nums.clone(), tgt);
        System.out.println("Target " + tgt + " found at index: " + idx + " (after sorting)");
    }
}