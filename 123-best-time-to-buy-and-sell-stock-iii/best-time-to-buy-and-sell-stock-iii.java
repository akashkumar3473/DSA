class Solution {
    int[][][] dp;
    int n;
    int solve(int i,int buy,int t, int[] p){
        if(i==n || t==2) return 0;
        if(dp[i][buy][t]!=-1) return dp[i][buy][t];
        int profit =0;
        if(buy==1){
            int take = -p[i] + solve(i+1,0,t,p);
            int skip = solve(i+1,1,t,p);
            profit =  Math.max(take,skip);
        }else{
            int sell = p[i] +solve(i+1,1,t+1,p);
            int skip = solve(i+1,0,t,p);
            profit =  Math.max(sell,skip);

        }
        return dp[i][buy][t]=profit;
    }
    public int maxProfit(int[] p) {
        n = p.length;
        dp = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,1,0,p);
    }
}