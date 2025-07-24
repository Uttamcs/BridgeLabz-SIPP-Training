package StackQueue;

import java.util.Stack;

class SortStackRecursion {
    
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }
    
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }
    }
    
    public static void printStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        while (!temp.isEmpty()) {
            int val = temp.pop();
            System.out.print(val + " ");
            stack.push(val);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);
        
        System.out.print("Original Stack: ");
        printStack(stack);
        
        sortStack(stack);
        
        System.out.print("Sorted Stack: ");
        printStack(stack);
    }
}