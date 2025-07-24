package StackQueue;

import java.util.*;

class ZeroSumSubarrays {
    
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (sumMap.containsKey(sum)) {
                List<Integer> indices = sumMap.get(sum);
                for (int startIndex : indices) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            
            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        
        System.out.print("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        List<int[]> subarrays = findZeroSumSubarrays(arr);
        
        System.out.println("Zero sum subarrays:");
        for (int[] subarray : subarrays) {
            System.out.println("From index " + subarray[0] + " to " + subarray[1]);
        }
    }
}