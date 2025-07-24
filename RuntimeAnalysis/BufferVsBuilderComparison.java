package RuntimeAnalysis;

public class BufferVsBuilderComparison {
    public static void testStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) / 1000000 + " ms");
    }
    
    public static void testStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) / 1000000 + " ms");
    }
    
    public static void main(String[] args) {
        int iterations = 1000000;
        System.out.println("Comparing performance for " + iterations + " string concatenations:");
        testStringBuffer(iterations);
        testStringBuilder(iterations);
    }
}