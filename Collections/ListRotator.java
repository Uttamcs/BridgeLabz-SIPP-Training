package Collections;

import java.util.ArrayList;
import java.util.List;

public class ListRotator {
    public static <T> List<T> rotateList(List<T> list, int positions) {
        int size = list.size();
        if (size == 0 || positions % size == 0) {
            return new ArrayList<>(list);
        }
        
        positions = positions % size;
        List<T> rotated = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            rotated.add(list.get((i + positions) % size));
        }
        
        return rotated;
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        
        int rotateBy = 2;
        List<Integer> rotated = rotateList(numbers, rotateBy);
        
        System.out.println("Original list: " + numbers);
        System.out.println("Rotated by " + rotateBy + ": " + rotated);
    }
}