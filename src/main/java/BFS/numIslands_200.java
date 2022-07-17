package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class numIslands_200 {


    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i, j});
        while(!queue.isEmpty()) {
            int[] pos = queue.remove();
            i = pos[0];
            j = pos[1];
            if (i <= grid.length -1 && i >= 0 && j <= grid[0].length -1 && j >= 0 && grid[i][j] == '1') {
                grid[i][j] = '0';
                queue.add(new int[] {i + 1, j});
                queue.add(new int[] {i - 1, j});
                queue.add(new int[] {i, j + 1});
                queue.add(new int[] {i, j - 1});
            }
        }
    }
}
