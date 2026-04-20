class Solution {
    Integer[] dp;
    public int solve(int i, int[] cost){
        if(i==0 || i==1) return cost[i];
        if(dp[i]!=null) return dp[i];
        return dp[i] = cost[i] + Math.min(solve(i-1,cost),solve(i-2,cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n =cost.length;
        dp = new Integer[n];
        return Math.min(solve(n-1,cost),solve(n-2,cost)); 
    }
}