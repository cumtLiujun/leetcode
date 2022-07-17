package Offer.Offer_29;

public class Solution {
//    主要是模拟 顺时针打印的顺序
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }
        int cols = matrix[0].length;
        int len = rows * cols;
        int[] res = new int[len];
        boolean[][] isVisit = new boolean[rows][cols];
        int[][] direction = {{0,1}, {1, 0}, {0, -1},{-1, 0}};
        int row = 0, col = 0, directionIndex = 0;
        for (int i = 0;i < len; i++) {
            res[i] = matrix[row][col];
            isVisit[row][col] = true;
            if (row + direction[directionIndex][0] >=rows || row + direction[directionIndex][0] < 0
            || col + direction[directionIndex][1] >=cols || col + direction[directionIndex][1] < 0
            || isVisit[row + direction[directionIndex][0]][col + direction[directionIndex][1]]) {
                directionIndex += 1;
                directionIndex %= 4;
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return res;
    }
}
