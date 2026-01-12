class Solution {
    int[][] dp;
    public int solve(int amount, int[] coins, int i){
        if(amount==0) return 1;
        if(amount<0 || i>=coins.length) return 0;
        if(dp[amount][i]!=-1) return dp[amount][i];
        int take = solve(amount-coins[i],coins,i);
        int skip = solve(amount,coins,i+1);
        return dp[amount][i] = take+skip;
    }
    public int change(int amount, int[] coins) {
        dp = new int[amount+1][coins.length];
        for(int i=0;i<=amount;i++){
             Arrays.fill(dp[i],-1);
        }
       
        return solve(amount,coins,0);
    }
}