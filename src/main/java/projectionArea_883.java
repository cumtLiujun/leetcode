public class projectionArea_883 {
    public int projectionArea(int[][] grid) {
        int n = grid[0].length;
        return notZero(grid,n) + rowMaxSum(grid, n) +colMaxSum(grid, n);
    }
    private static int rowMaxSum(int score[][], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + rowMax(score[i], n);
        }
        return sum;
    }
    private static int rowMax(int a[], int n) {
        int max = a[0];
        for (int i = 1; i < n; i++)
            if (max < a[i])
                max = a[i];
        return max;
    }
    private static int colMaxSum(int a[][], int n) {
        int res = 0;
        int max;
        int i, j;
        for (i = 0; i < n; i++) {
            max = a[0][i];
            for (j = 0; j < n; j++) {
                if (max < a[j][i])
                    max = a[j][i];
            }
            res += max;
        }
        return res;
    }
    private static int notZero(int a[][], int n) {
        int sum = 0;
        int i, j;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++) {
                if (a[i][j]!=0) sum++;
            }
        return sum;
    }
}
