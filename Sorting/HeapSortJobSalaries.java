package Sorting;

class HeapSortJobSalaries {
    
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print("$" + value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] jobSalaries = {75000, 45000, 95000, 60000, 85000, 55000, 70000};
        
        System.out.print("Original salary demands: ");
        printArray(jobSalaries);
        
        heapSort(jobSalaries);
        
        System.out.print("Sorted salary demands: ");
        printArray(jobSalaries);
    }
}