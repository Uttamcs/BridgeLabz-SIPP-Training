package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListReverser {
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }
    
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        
        List<Integer> reversedArrayList = reverseList(arrayList);
        System.out.println("Original ArrayList: " + arrayList);
        System.out.println("Reversed ArrayList: " + reversedArrayList);
        
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        
        List<Integer> reversedLinkedList = reverseList(linkedList);
        System.out.println("Original LinkedList: " + linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}