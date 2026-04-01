class Solution {
    int MOD = 1_000_000_007;
    Integer[][][] dp;
    public int solve(int i, int n, int ab, int L) {
        if (i == n) return 1;
        if(dp[i][ab][L]!=null) return dp[i][ab][L];
        int c1 = solve(i + 1, n, ab, 0); 

        int c2 = 0;
        if (ab == 0) {
            c2 = solve(i + 1, n, ab + 1, 0); 
        }

        int c3 = 0;
        if (L < 2) {
            c3 = solve(i + 1, n, ab, L + 1); 
        }

        return dp[i][ab][L] = (int)(((long)c1 + c2 + c3) % MOD);
    }

    public int checkRecord(int n) {
        dp = new Integer[n][2][3];

        return solve(0, n, 0, 0);
    }
}