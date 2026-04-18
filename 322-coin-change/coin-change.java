class Solution {
    public int coinChange(int[] coins, int t) {
        int n = coins.length;
        int[][] dp = new int[n][t+1];
        
        // base case
        for(int target =0;target<=t;target++){
            if(target%coins[0]==0) dp[0][target] = target/coins[0];
            else dp[0][target] = (int)1e9;
        }

        for(int i=1;i<n;i++){
            for(int target =0;target<=t;target++){
                int skip = dp[i-1][target];

                int take = (int)1e9;
                if(coins[i]<=target){
                    take = 1 + dp[i][target-coins[i]];
                }
                dp[i][target] = Math.min(skip,take);
            }
        }
       
        int ans = dp[n-1][t];
        return ans >= (int)1e9 ? -1 : ans;
    }
}