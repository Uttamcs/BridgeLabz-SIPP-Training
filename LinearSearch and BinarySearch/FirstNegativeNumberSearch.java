package LinearSearch;

public class FirstNegativeNumberSearch {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 8, 2, -3, 9, -7, 1};
        int idx = findFirstNegative(nums);
        
        if (idx != -1) {
            System.out.println("First negative number found at index: " + idx);
        } else {
            System.out.println("No negative number found in the array");
        }
    }
}