class Solution {
    int[][][] dp;
    int MOD = 1_000_000_007;
    int m, n;

    int solve(int i, int j, int ml) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 1;
        if (ml == 0) return 0;

        if (dp[i][j][ml] != -1) return dp[i][j][ml];

        long up = solve(i - 1, j, ml - 1);
        long down = solve(i + 1, j, ml - 1);
        long left = solve(i, j - 1, ml - 1);
        long right = solve(i, j + 1, ml - 1);

        return dp[i][j][ml] = (int)((up + down + left + right) % MOD);
    }

    public int findPaths(int m, int n, int mm, int sr, int sc) {
        this.m = m;
        this.n = n;

        dp = new int[m][n][mm + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= mm; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(sr, sc, mm);
    }
}