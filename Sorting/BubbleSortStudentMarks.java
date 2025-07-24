package Sorting;

class BubbleSortStudentMarks {
    
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] studentMarks = {85, 92, 78, 96, 88, 74, 91, 83};
        
        System.out.print("Original marks: ");
        printArray(studentMarks);
        
        bubbleSort(studentMarks);
        
        System.out.print("Sorted marks: ");
        printArray(studentMarks);
    }
}