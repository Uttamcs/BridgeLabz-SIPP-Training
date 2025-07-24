package Collections;

import java.util.LinkedList;

public class NthElementFinder {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            return null;
        }
        
        int size = list.size();
        if (n > size) {
            return null;
        }
        
        return list.get(size - n);
    }
    
    public static void main(String[] args) {
        LinkedList<String> letters = new LinkedList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        
        int n = 2;
        String nthElement = findNthFromEnd(letters, n);
        
        System.out.println("List: " + letters);
        System.out.println(n + "nd element from the end: " + nthElement);
    }
}