class Solution {
    int[][][] dp;
    int n;
    int solve(int i,int buy, int k,int t, int[] p){
        if(i==n || t==k) return 0;
        if(dp[i][buy][t]!=-1) return dp[i][buy][t];
        int profit =0;
        if(buy==0){
            int take = -p[i] + solve(i+1,1,k,t,p);
            int skip = solve(i+1,0,k,t,p);
            profit = Math.max(take,skip);
        }else{
            int sell = p[i] + solve(i+1,0,k,t+1,p);
            int skip = solve(i+1,1,k,t,p);
            profit = Math.max(sell,skip);
        }
        return dp[i][buy][t] = profit;
    }
    public int maxProfit(int k, int[] p) {
        n = p.length;
        dp = new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,k,0,p);
    }
}