package dp;

public class maximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxsize = 0;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxsize =  Math.max(maxsize, dp[i][0]);
        }
        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i] - '0';
            maxsize =  Math.max(maxsize, dp[0][i]);
        }

        for (int i = 1 ;i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j- 1])) + 1;
                }
                maxsize =  Math.max(maxsize, dp[i][j]);
            }
        }
        return maxsize * maxsize;
    }
}
