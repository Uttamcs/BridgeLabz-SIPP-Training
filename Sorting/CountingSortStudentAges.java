package Sorting;

class CountingSortStudentAges {
    
    public static void countingSort(int[] ages) {
        int min = 10, max = 18;
        int range = max - min + 1;
        
        int[] count = new int[range];
        int[] output = new int[ages.length];
        
        for (int age : ages) {
            count[age - min]++;
        }
        
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }
        
        System.arraycopy(output, 0, ages, 0, ages.length);
    }
    
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] studentAges = {16, 14, 18, 12, 17, 15, 13, 16, 14, 18};
        
        System.out.print("Original student ages: ");
        printArray(studentAges);
        
        countingSort(studentAges);
        
        System.out.print("Sorted student ages: ");
        printArray(studentAges);
    }
}