class Solution {
    Integer[] dp;

    public int solve(int i, int[] s) {
        if (i == 0) return 0;
        if (i == 1) return s[1] - s[0];

        if (dp[i] != null) return dp[i];

        int curr = s[i] - s[i - 2];
        int prev = solve(i - 1, s);

        return dp[i] = Math.max(curr, prev);
    }

    public int maxJump(int[] s) {
        int n = s.length;
        dp = new Integer[n];
        return solve(n - 1, s);
    }
}