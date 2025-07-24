package BinarySearch;

public class MatrixSearch {
    public static boolean searchMatrix(int[][] mat, int tgt) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }
        
        int rows = mat.length;
        int cols = mat[0].length;
        int l = 0;
        int r = rows * cols - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / cols;
            int col = m % cols;
            
            if (mat[row][col] == tgt) {
                return true;
            } else if (mat[row][col] < tgt) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        
        int tgt = 16;
        boolean found = searchMatrix(mat, tgt);
        
        System.out.println("Target " + tgt + " found in matrix: " + found);
    }
}