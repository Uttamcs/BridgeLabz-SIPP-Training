package Sorting;

class QuickSortProductPrices {
    
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }
    
    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                swap(prices, i, j);
            }
        }
        
        swap(prices, i + 1, high);
        return i + 1;
    }
    
    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void printArray(double[] arr) {
        for (double value : arr) {
            System.out.print("$" + value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        double[] productPrices = {199.99, 89.50, 299.75, 45.99, 150.25, 75.00, 399.99};
        
        System.out.print("Original product prices: ");
        printArray(productPrices);
        
        quickSort(productPrices, 0, productPrices.length - 1);
        
        System.out.print("Sorted product prices: ");
        printArray(productPrices);
    }
}