import java.util.Scanner;

public class MatrixAdvanced {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Matrix Operations:");
        System.out.println("1. Transpose");
        System.out.println("2. Determinant (2x2 or 3x3)");
        System.out.println("3. Inverse (2x2 or 3x3)");
        
        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();
        
        int rows, cols;
        
        if (choice == 1) {
            System.out.print("Enter number of rows: ");
            rows = sc.nextInt();
            System.out.print("Enter number of columns: ");
            cols = sc.nextInt();
        } else {
            System.out.print("Enter matrix size (2 or 3): ");
            rows = cols = sc.nextInt();
            
            if (rows != 2 && rows != 3) {
                System.out.println("Only 2x2 or 3x3 matrices are supported for this operation.");
                return;
            }
        }
        
        double[][] matrix = createRandomMatrix(rows, cols);
        
        System.out.println("\nOriginal Matrix:");
        displayMatrix(matrix);
        
        switch (choice) {
            case 1:
                double[][] transpose = findTranspose(matrix);
                System.out.println("\nTranspose:");
                displayMatrix(transpose);
                break;
            case 2:
                double determinant;
                if (rows == 2) {
                    determinant = findDeterminant2x2(matrix);
                } else {
                    determinant = findDeterminant3x3(matrix);
                }
                System.out.println("\nDeterminant: " + determinant);
                break;
            case 3:
                if (rows == 2) {
                    double det = findDeterminant2x2(matrix);
                    if (Math.abs(det) < 0.0001) {
                        System.out.println("\nMatrix is not invertible (determinant is zero).");
                        return;
                    }
                    double[][] inverse = findInverse2x2(matrix);
                    System.out.println("\nInverse:");
                    displayMatrix(inverse);
                } else {
                    double det = findDeterminant3x3(matrix);
                    if (Math.abs(det) < 0.0001) {
                        System.out.println("\nMatrix is not invertible (determinant is zero).");
                        return;
                    }
                    double[][] inverse = findInverse3x3(matrix);
                    System.out.println("\nInverse:");
                    displayMatrix(inverse);
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
    
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Math.round(Math.random() * 10);
            }
        }
        
        return matrix;
    }
    
    public static double[][] findTranspose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        double[][] transpose = new double[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        return transpose;
    }
    
    public static double findDeterminant2x2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
    
    public static double findDeterminant3x3(double[][] matrix) {
        double a = matrix[0][0];
        double b = matrix[0][1];
        double c = matrix[0][2];
        
        double det1 = a * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]);
        double det2 = b * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
        double det3 = c * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        
        return det1 - det2 + det3;
    }
    
    public static double[][] findInverse2x2(double[][] matrix) {
        double det = findDeterminant2x2(matrix);
        double[][] inverse = new double[2][2];
        
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        
        return inverse;
    }
    
    public static double[][] findInverse3x3(double[][] matrix) {
        double det = findDeterminant3x3(matrix);
        double[][] inverse = new double[3][3];
        
        // Calculate cofactor matrix
        double[][] cofactor = new double[3][3];
        
        cofactor[0][0] = matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1];
        cofactor[0][1] = -(matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
        cofactor[0][2] = matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0];
        
        cofactor[1][0] = -(matrix[0][1] * matrix[2][2] - matrix[0][2] * matrix[2][1]);
        cofactor[1][1] = matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0];
        cofactor[1][2] = -(matrix[0][0] * matrix[2][1] - matrix[0][1] * matrix[2][0]);
        
        cofactor[2][0] = matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1];
        cofactor[2][1] = -(matrix[0][0] * matrix[1][2] - matrix[0][2] * matrix[1][0]);
        cofactor[2][2] = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        
        // Transpose of cofactor matrix
        double[][] adjoint = findTranspose(cofactor);
        
        // Divide by determinant
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = adjoint[i][j] / det;
            }
        }
        
        return inverse;
    }
    
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%.2f\t", element);
            }
            System.out.println();
        }
    }
}