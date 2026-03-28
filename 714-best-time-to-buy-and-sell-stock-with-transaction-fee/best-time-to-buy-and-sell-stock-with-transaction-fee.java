class Solution {
    int[][] dp;
    int n;
    int solve(int i, int buy,int [] p, int f){
        if(i==n) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit = 0;
        if(buy==0){
            int take = -p[i]+solve(i+1,1,p,f);
            int skip= solve(i+1,0,p,f);
            profit = Math.max(take,skip);
        }
        else{
            int sell = p[i] - f + solve(i+1,0,p,f);
            int skip = solve(i+1,1,p,f);
            profit = Math.max(sell,skip);
        }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] p, int f) {
        n = p.length;
        dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,p,f);
    }
}