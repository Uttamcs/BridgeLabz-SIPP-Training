package BinarySearch;

public class RotationPointFinder {
    public static int findRotationPoint(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (arr[m] > arr[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int pivot = findRotationPoint(arr);
        
        System.out.println("Rotation point index: " + pivot);
        System.out.println("Smallest element: " + arr[pivot]);
    }
}