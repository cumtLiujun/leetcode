package backtracking;

public class exist_79 {

    private final static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
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
        wordCharArray = word.toCharArray();
        len = wordCharArray.length;
        isVisited = new boolean[rows][cols];
        this.board = board;
        //寻找入口
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int index) {
        if (index == len - 1) {
            return board[x][y] == wordCharArray[index];
        }

        if (board[x][y] == wordCharArray[index]) {
            isVisited[x][y] = true;
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !isVisited[newX][newY]) {
                    if (dfs(newX,newY,index +1)) {
                        return true;
                    }
                }
            }
            isVisited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
