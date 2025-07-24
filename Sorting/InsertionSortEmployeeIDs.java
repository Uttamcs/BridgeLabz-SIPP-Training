package Sorting;

class InsertionSortEmployeeIDs {
    
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;
            
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] employeeIDs = {1045, 1012, 1089, 1003, 1067, 1034, 1098};
        
        System.out.print("Original Employee IDs: ");
        printArray(employeeIDs);
        
        insertionSort(employeeIDs);
        
        System.out.print("Sorted Employee IDs: ");
        printArray(employeeIDs);
    }
}