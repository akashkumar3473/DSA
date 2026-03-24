import java.util.*;

class Solution {
    int[][] dp;
    int MOD = 1000000007;

    int[][] moves = {
        {4,6},    
        {6,8},    
        {7,9},   
        {4,8},    
        {0,3,9},  
        {},       
        {0,1,7},  
        {2,6},    
        {1,3},    
        {2,4}     
    };

    int solve(int d, int s){
        if(s == 1) return 1;

        if(dp[d][s] != -1) return dp[d][s];

        long ways = 0;

        for (int next : moves[d]) {
            ways = (ways + solve(next, s - 1)) % MOD;
        }

        return dp[d][s] = (int) ways;
    }

    public int knightDialer(int n) {
        dp = new int[10][n + 1];

        
        for(int i = 0; i < 10; i++){
            Arrays.fill(dp[i], -1);
        }

        long ans = 0;

        for(int i = 0; i < 10; i++){
            ans = (ans + solve(i, n)) % MOD;
        }

        return (int) ans;
    }
}