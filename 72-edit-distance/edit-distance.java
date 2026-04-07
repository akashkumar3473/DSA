class Solution {
    Integer[][] dp;
    int n1;
    int n2;
    public int solve(int i, int j, String w1, String w2){
        if(i==n1) return n2-j;
        if(j==n2) return n1-i;
        if(dp[i][j]!=null) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)) return solve(i+1,j+1,w1,w2);

        int insert = 1+solve(i,j+1,w1,w2);
        int delete = 1+solve(i+1,j,w1,w2);
        int replace = 1+ solve(i+1,j+1,w1,w2);

        return dp[i][j] = Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String w1, String w2) {
        n1 = w1.length();
        n2 = w2.length();
        dp = new Integer[n1][n2];
        return solve(0,0,w1,w2);
    }
}