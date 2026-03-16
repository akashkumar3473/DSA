class Solution {
    static int dp[][];
    public int solve(int i,int prev,int[] nums){
        if(i>=nums.length)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int pick=0,nopick=solve(i+1,prev,nums);
        if(prev==-1||nums[prev]<nums[i])pick=1+solve(i+1,i,nums);
        return dp[i][prev+1]=Math.max(pick,nopick);
    }
    public int lengthOfLIS(int[] nums) {
        int n  = nums.length;
        dp=new int[n+1][n+1];
        for(int[] r:dp)Arrays.fill(r,-1);
        return solve(0,-1,nums);
    }
}