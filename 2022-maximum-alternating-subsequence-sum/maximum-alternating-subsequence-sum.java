class Solution {
    long[][] dp;
    public long solve(int[] nums, int i, int n,int pos){
        if(i>=n) return 0;
        if(dp[i][pos]!=-1) return dp[i][pos];
        // take

        long take;
        if(pos == 0){
            take = nums[i] + solve(nums,i+1,n,1);
        }
        else{
            take = -nums[i] + solve(nums,i+1,n,0);
        }
        long skip = solve(nums,i+1,n,pos);
        return dp[i][pos] = Math.max(take,skip);
    }
    public long maxAlternatingSum(int[] nums) {
        final int n = nums.length;
        dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums,0,n,0);
    }
}