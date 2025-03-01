
public class AddTwoMatrix {
	public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };
        
        int[][] matrix2 = {
            {9, 8, 7},
            {9, 8, 7},
            {9, 8, 7}
        };

        int[][] result = addMatrices(matrix1, matrix2);
        
        // Displaying the result
        System.out.println("Resultant Matrix after addition:");
        displayMatrix(result);
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

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
