class Solution {
    Integer[] dp;
    public int solve(int i, int n){
        if(i==n) return 1;
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];
        return dp[i] = solve(i+1,n) + solve(i+2,n);
    }
    public int climbStairs(int n) {
        dp = new Integer[n];
        return solve(0,n);
    }
}