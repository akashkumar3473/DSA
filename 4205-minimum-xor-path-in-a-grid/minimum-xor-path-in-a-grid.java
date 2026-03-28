class Solution {
    Integer[][][] dp;

    private int solve(int r, int c, int xor, int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int newxor = xor ^ grid[r][c];

        if (r == n - 1 && c == m - 1)
            return newxor;

        if (dp[r][c][xor] != null)
            return dp[r][c][xor];

        int res = Integer.MAX_VALUE;

        if (c + 1 < m)
            res = Math.min(res, solve(r, c + 1, newxor, grid));

        if (r + 1 < n)
            res = Math.min(res, solve(r + 1, c, newxor, grid));

        return dp[r][c][xor] = res;
    }

    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new Integer[n][m][1024];
        return solve(0, 0, 0, grid);
    }
}