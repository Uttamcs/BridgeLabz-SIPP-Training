import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Matrix Operations:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        
        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();
        
        System.out.print("Enter number of rows for first matrix: ");
        int rows1 = sc.nextInt();
        System.out.print("Enter number of columns for first matrix: ");
        int cols1 = sc.nextInt();
        
        int[][] matrix1 = createRandomMatrix(rows1, cols1);
        
        System.out.println("\nFirst Matrix:");
        displayMatrix(matrix1);
        
        int rows2, cols2;
        
        if (choice == 3) {
            rows2 = cols1;
            System.out.print("Enter number of columns for second matrix: ");
            cols2 = sc.nextInt();
        } else {
            rows2 = rows1;
            cols2 = cols1;
        }
        
        int[][] matrix2 = createRandomMatrix(rows2, cols2);
        
        System.out.println("\nSecond Matrix:");
        displayMatrix(matrix2);
        
        int[][] result = null;
        
        switch (choice) {
            case 1:
                result = addMatrices(matrix1, matrix2);
                System.out.println("\nMatrix Addition Result:");
                break;
            case 2:
                result = subtractMatrices(matrix1, matrix2);
                System.out.println("\nMatrix Subtraction Result:");
                break;
            case 3:
                result = multiplyMatrices(matrix1, matrix2);
                System.out.println("\nMatrix Multiplication Result:");
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        displayMatrix(result);
        
        sc.close();
    }
    
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }
        
        return matrix;
    }
    
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        return result;
    }
    
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        
        return result;
    }
    
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        
        int[][] result = new int[rows1][cols2];
        
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        return result;
    }
    
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}