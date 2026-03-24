class Solution {
    int mod = 1000000007;
    int[][][] dp;
    int m;

    int solve(int i, int ml, int pn, int[] g, int[] p, int mp) {
        if (i == m) {
            return (pn >= mp) ? 1 : 0;
        }

        if (dp[i][ml][pn] != -1) {
            return dp[i][ml][pn];
        }

        // skip
        int skip = solve(i + 1, ml, pn, g, p, mp);

        // take
        int take = 0;
        if (ml >= g[i]) {
            int newProfit = Math.min(mp, pn + p[i]); 
            take = solve(i + 1, ml - g[i], newProfit, g, p, mp);
        }

        return dp[i][ml][pn] = (skip + take) % mod;
    }

    public int profitableSchemes(int n, int mp, int[] g, int[] p) {
        m = g.length;

        dp = new int[m][n + 1][mp + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= mp; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, n, 0, g, p, mp);
    }
}