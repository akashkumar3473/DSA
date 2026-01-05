class Solution {
    public int solve(int[] nums, int i,int n,int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i] + solve(nums,i+2,n,dp);
        int skip = solve(nums,i+1,n,dp);
        return dp[i] =  Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        int idx0 = solve(nums,0,n-1,dp);
        Arrays.fill(dp,-1);
        int idx1 = solve(nums,1,n,dp);
        return Math.max(idx0,idx1);
       

    }
}