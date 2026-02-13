class Solution {

    public int dfs(int i, int j, int[][] grid, int m, int n) {

      
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0)
            return 0;

        // visited
        grid[i][j] = 0;

        int area = 1;

        area += dfs(i - 1, j, grid, m, n); // up
        area += dfs(i + 1, j, grid, m, n); // down
        area += dfs(i, j - 1, grid, m, n); // left
        area += dfs(i, j + 1, grid, m, n); // right

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid, m, n);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
