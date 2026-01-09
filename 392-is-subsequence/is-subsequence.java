class Solution {
    int[][] dp;
    public boolean solve(String s,String t,int i, int j, int m, int n){
        if(i==m) return true;
        if(j==n) return false;
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        boolean ans;
        if (s.charAt(i) == t.charAt(j)) {
            ans = solve(s, t, i + 1, j + 1, m, n);
        } else {
            ans = solve(s, t, i, j + 1, m, n);
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;

    }
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,t,0,0,m,n);
    }
}