public class rotate_48 {
    /*
    方法1： 构造辅助矩阵，未在原有矩阵上直接修改，时间复杂度和空间复杂度都略大，略有不符合题意
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] m = new int[length][length];
//       旋转公式为： m[r][c] = m[c][n-r-1]
//       构造辅助矩阵，存储旋转之后的数据
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                m[j][length - i - 1] = matrix[i][j];
            }
        }
//        复制回原来矩阵
        for (int i = 0; i < length; i++) {
            System.arraycopy(m[i], 0, matrix[i], 0, length);
        }

    }

    /*
    方法2： 翻转矩阵，根据观察可得，旋转90度，可根据翻转交换得来，先水平翻转，然后翻转对角线
     */

    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
