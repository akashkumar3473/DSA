class Solution {
    int mod = 1000000007;
    long[][] dp;
    long solve(String s, int i, int seats){
        if(i==s.length()){
            return seats==2?1:0;
        }
        if(dp[i][seats]!=-1) return dp[i][seats];
        char ch = s.charAt(i);
        long opt1 = 0, opt2 = 0;
        if(ch=='S'){
            if(seats==2){
                opt1 = solve(s,i+1,1);
            }else{
                opt1 = solve(s,i+1,seats+1);
            }
        }
        else{
            opt1 = solve(s,i+1,seats);
            if(seats==2)
                opt2 = solve(s,i+1,0);
        }
        return dp[i][seats] = (opt1+opt2)%mod;
    }
    public int numberOfWays(String c) {
        int n = c.length();
        dp = new long[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return (int)solve(c,0,0);
    }
}