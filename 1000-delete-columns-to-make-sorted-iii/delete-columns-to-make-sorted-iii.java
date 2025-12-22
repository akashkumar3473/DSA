class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        int max = 1;
        for(int i=0; i<m; i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(isValid(strs,j,i)){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max  = Math.max(max,dp[i]);
        }
        return m - max;
    }
    private boolean isValid(String[] strs, int c1, int c2){
        for(String s : strs){
            if(s.charAt(c1)> s.charAt(c2)){
                return false;
            }
        }
        return true;
    }
}