package StackQueue;

import java.util.HashMap;
import java.util.Map;

class TwoSumProblem {
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
    
    public static boolean hasPairWithSum(int[] arr, int target) {
        Map<Integer, Boolean> visited = new HashMap<>();
        
        for (int num : arr) {
            int complement = target - num;
            if (visited.containsKey(complement)) {
                return true;
            }
            visited.put(num, true);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        System.out.print("Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Target: " + target);
        
        int[] indices = twoSum(nums, target);
        if (indices.length > 0) {
            System.out.println("Indices: " + indices[0] + ", " + indices[1]);
            System.out.println("Values: " + nums[indices[0]] + " + " + nums[indices[1]] + " = " + target);
        }
        
        boolean hasPair = hasPairWithSum(nums, target);
        System.out.println("Has pair with sum " + target + ": " + hasPair);
    }
}