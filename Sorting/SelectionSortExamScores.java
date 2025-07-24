package Sorting;

class SelectionSortExamScores {
    
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] examScores = {78, 92, 85, 67, 94, 88, 76, 91};
        
        System.out.print("Original exam scores: ");
        printArray(examScores);
        
        selectionSort(examScores);
        
        System.out.print("Sorted exam scores: ");
        printArray(examScores);
    }
}