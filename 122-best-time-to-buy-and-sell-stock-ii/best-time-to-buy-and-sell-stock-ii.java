class Solution {
    int[][] dp;
    int solve(int i,int buy,int[] p,int n){
        if(i==n) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit = 0;
        if(buy==1){
            int take = -p[i]+solve(i+1,0,p,n);
            int skip = solve(i+1,1,p,n);
            profit = Math.max(take,skip);
        }else{
            int sell = p[i] + solve(i+1,1,p,n);
            int skip = solve(i+1,0,p,n);
            profit = Math.max(sell,skip);
            
        }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] p) {
        int n = p.length;
        dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,1,p,n);
    }
}