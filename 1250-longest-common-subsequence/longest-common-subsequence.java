class Solution {
    int[][] dp;
    public int solve(String s1,String s2,int i,int j,int m, int n){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
           return 1 + solve(s1,s2,i-1,j-1,m,n);
        else{
            int skip_i = solve(s1,s2,i-1,j,m,n);
            int skip_j = solve(s1,s2,i,j-1,m,n);
            return dp[i][j] =  Math.max(skip_i,skip_j);
        }
    }
    public int longestCommonSubsequence(String t1, String t2) {
        int m = t1.length();
        int n = t2.length();
        dp = new int[m][n];
        for(int i=0;i<m;i++){ 
            Arrays.fill(dp[i],-1);
        }
        
        return solve(t1,t2,m-1,n-1,m,n);
    }
}