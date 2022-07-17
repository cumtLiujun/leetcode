package ArrayList;

public class searchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = rows - 1;
        int j = 0;

        while(i >= 0 && j < cols) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
