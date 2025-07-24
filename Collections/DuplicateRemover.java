package Collections;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class DuplicateRemover {
    public static <T> List<T> removeDuplicates(List<T> list) {
        LinkedHashSet<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        
        List<Integer> withoutDuplicates = removeDuplicates(numbers);
        
        System.out.println("Original list: " + numbers);
        System.out.println("Without duplicates: " + withoutDuplicates);
    }
}