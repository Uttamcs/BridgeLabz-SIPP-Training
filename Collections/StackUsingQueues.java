package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues<T> {
    private Queue<T> q1;
    private Queue<T> q2;
    
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(T value) {
        q2.add(value);
        
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public T pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.remove();
    }
    
    public T top() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek();
    }
    
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    
    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top element: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
    }
}