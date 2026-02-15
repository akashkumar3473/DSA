import java.util.*;

class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;   // mark starting cell visited

        while (!q.isEmpty()) {

            Pair front = q.remove();
            int r = front.row;
            int c = front.col;

            // top
            if (r - 1 >= 0 && !vis[r - 1][c] && grid[r - 1][c] == '1') {
                q.add(new Pair(r - 1, c));
                vis[r - 1][c] = true;
            }

            // down
            if (r + 1 < m && !vis[r + 1][c] && grid[r + 1][c] == '1') {
                q.add(new Pair(r + 1, c));
                vis[r + 1][c] = true;
            }

            // left
            if (c - 1 >= 0 && !vis[r][c - 1] && grid[r][c - 1] == '1') {
                q.add(new Pair(r, c - 1));
                vis[r][c - 1] = true;
            }

            // right
            if (c + 1 < n && !vis[r][c + 1] && grid[r][c + 1] == '1') {
                q.add(new Pair(r, c + 1));
                vis[r][c + 1] = true;
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }

        return count;
    }
}
