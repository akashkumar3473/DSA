class Solution {
    Integer[][] dp;
    int n;
    public int solve(int i,List<List<Integer>> p,int k){
        if(i>=n || k==0) return 0;
        if(dp[i][k]!=null) return dp[i][k];
        int ans = 0;
        int sum= 0;
        
        ans = Math.max(ans,solve(i+1,p,k));
        for(int j=0;j<p.get(i).size();j++){
            sum += p.get(i).get(j);
            if(k>=j+1) ans = Math.max(ans,sum+solve(i+1,p,k-(j+1)));
        }
        return dp[i][k] =  ans;
    }
    public int maxValueOfCoins(List<List<Integer>> p, int k) {
        n = p.size();
        dp = new Integer[n][k+1];
        return solve(0,p,k);
    }
}