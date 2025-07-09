package Sorting;

class MergeSortBookPrices {
    
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            
            merge(prices, left, mid, right);
        }
    }
    
    private static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];
        
        System.arraycopy(prices, left, leftArray, 0, n1);
        System.arraycopy(prices, mid + 1, rightArray, 0, n2);
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    public static void printArray(double[] arr) {
        for (double value : arr) {
            System.out.print("$" + value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        double[] bookPrices = {29.99, 15.50, 42.75, 8.99, 35.25, 19.95, 55.00};
        
        System.out.print("Original book prices: ");
        printArray(bookPrices);
        
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        
        System.out.print("Sorted book prices: ");
        printArray(bookPrices);
    }
}