package Collections;

import java.util.HashMap;
import java.util.Map;

public class MaxValueFinder {
    public static <K> K findKeyWithMaxValue(Map<K, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        
        K maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        
        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        
        return maxKey;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("A", 10);
        scores.put("B", 20);
        scores.put("C", 15);
        
        String keyWithMaxValue = findKeyWithMaxValue(scores);
        
        System.out.println("Map: " + scores);
        System.out.println("Key with maximum value: " + keyWithMaxValue);
    }
}