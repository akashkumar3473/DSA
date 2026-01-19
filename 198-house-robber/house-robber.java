class Solution {
    int[] dp;
    public int solve(int[] nums, int i, int n){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i] + solve(nums,i+2,n);
        int skip = solve(nums,i+1,n);
        return dp[i] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,0,n);
    }
}