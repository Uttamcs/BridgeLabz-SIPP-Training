package StackQueue;

class HashNode {
    int key;
    int value;
    HashNode next;
    
    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class CustomHashMap {
    private HashNode[] buckets;
    private int capacity;
    private int size;
    
    public CustomHashMap() {
        this.capacity = 16;
        this.buckets = new HashNode[capacity];
        this.size = 0;
    }
    
    private int hash(int key) {
        return Math.abs(key) % capacity;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        HashNode head = buckets[index];
        
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        HashNode newNode = new HashNode(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }
    
    public int get(int key) {
        int index = hash(key);
        HashNode head = buckets[index];
        
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        HashNode head = buckets[index];
        
        if (head != null && head.key == key) {
            buckets[index] = head.next;
            size--;
            return;
        }
        
        while (head != null && head.next != null) {
            if (head.next.key == key) {
                head.next = head.next.next;
                size--;
                return;
            }
            head = head.next;
        }
    }
    
    public boolean containsKey(int key) {
        return get(key) != -1;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            HashNode head = buckets[i];
            while (head != null) {
                System.out.print("(" + head.key + "," + head.value + ") ");
                head = head.next;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        
        map.put(1, 10);
        map.put(2, 20);
        map.put(17, 30); // Will hash to same bucket as 1
        map.put(3, 40);
        
        System.out.println("HashMap contents:");
        map.display();
        
        System.out.println("\nGet operations:");
        System.out.println("Key 1: " + map.get(1));
        System.out.println("Key 2: " + map.get(2));
        System.out.println("Key 17: " + map.get(17));
        System.out.println("Key 5: " + map.get(5));
        
        map.remove(2);
        System.out.println("\nAfter removing key 2:");
        map.display();
        
        System.out.println("Size: " + map.size());
    }
}