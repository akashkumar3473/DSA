class Solution {
    Integer[][][] dp;
    int n;
    public int solve(int i,int j ,String s, int k ){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j][k]!=null) return dp[i][j][k];
        int take =0, skip =0, moveIdx =0;
        if(s.charAt(i)==s.charAt(j)){
            take = 2+solve(i+1,j-1,s,k);
            // moveIdx = Math.max(solve(i+1,j,s,k), solve(i,j-1,s,k));
        }
        else{
            int f = Math.abs(s.charAt(i)-s.charAt(j));
            int b = 26-f;
            if(k>=Math.min(f,b)){
                take = 2+solve(i+1,j-1,s,k-Math.min(f,b));
            }
             moveIdx = Math.max(solve(i+1,j,s,k), solve(i,j-1,s,k));

        }
        return dp[i][j][k] = Math.max(take,moveIdx);
    }
    public int longestPalindromicSubsequence(String s, int k) {
        n = s.length();
        dp = new Integer[n+1][n+1][k+1];
        return solve(0,n-1,s,k);
    }
}