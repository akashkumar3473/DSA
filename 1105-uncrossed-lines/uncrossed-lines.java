class Solution {
    
    public int maxUncrossedLines(int[] n1, int[] n2) {
        int n = n1.length, m=n2.length;
        int [][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] =0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(n1[i-1]==n2[j-1]){ 
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}