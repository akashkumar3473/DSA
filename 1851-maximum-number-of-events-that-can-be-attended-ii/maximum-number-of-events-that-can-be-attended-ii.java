class Solution {
    int[][] dp;
    public int solve(int[][] e, int k, int i){
        if(k<=0) return 0;
        if(i>=e.length) return 0;
        if(dp[k][i]!=-1) return dp[k][i];
        int target = e[i][1] + 1;
        int lo = i+1, hi= e.length-1;
        while(lo<=hi){
            int mid = lo +(hi-lo)/2;
            if(e[mid][0]>=target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        int take = e[i][2] + solve(e,k-1,lo);
        int skip = solve(e,k,i+1);
        return dp[k][i] = Math.max(take,skip);
    }
    public int maxValue(int[][] e, int k) {
        Arrays.sort(e,(a,b)->a[0]-b[0]);
        dp = new int[k+1][e.length];
        for(int i=0;i<=k;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(e,k,0);
    }
}