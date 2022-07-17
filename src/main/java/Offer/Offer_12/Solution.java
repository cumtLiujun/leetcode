package Offer.Offer_12;

public class Solution {
    private final static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int rows;
    private int cols;
    private int len;
    private char[] wordCharArray;
    private boolean[][] isVisited;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        len = word.length();
        isVisited = new boolean[rows][cols];
        wordCharArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (index == len - 1) {
            return board[i][j] == wordCharArray[index];
        }

        if (board[i][j] == wordCharArray[index]) {
            isVisited[i][j] = true;
            for (int[] direction : directions) {
                int x = direction[0] + i;
                int y = direction[1] + j;
                if (inArea(x,y)&&!isVisited[x][y]){
                    if (dfs(x, y, index+1)) {
                        return true;
                    }
                }
            }
//           对访问的节点进行回溯
            isVisited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}
