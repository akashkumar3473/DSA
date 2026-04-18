class Solution {
    Integer[][] dp;
    public int solve(int idx,int[] coins,int t){
        if(idx==0){
            if(t%coins[idx]==0) return t/coins[idx];
            else return (int)1e9;
        }
        if(dp[idx][t]!=null) return dp[idx][t];
        int skip = solve(idx-1,coins,t);

        int take = (int)1e9;
        if(coins[idx]<=t){
            take = 1 + solve(idx,coins,t-coins[idx]);
        }
        return dp[idx][t] = Math.min(take,skip);
    }
    public int coinChange(int[] coins, int t) {
        int n = coins.length;
        dp = new Integer[n][t+1];
        int ans = solve(n-1,coins,t);
        return ans >= (int)1e9 ? -1 : ans;
    }
}