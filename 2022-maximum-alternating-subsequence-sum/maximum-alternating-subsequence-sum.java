class Solution {
    public long solve(int[] nums,int i, int n,int si,long[][] dp){
        if(i>=n) return 0;
        int siIdx = (si == 1) ? 0 : 1;
        if (dp[i][siIdx] != -1) return dp[i][siIdx];
        long take =si * nums[i] + solve(nums,i+1,n,-si,dp);
        long skip = solve(nums,i+1,n,si,dp);
        return dp[i][siIdx] = Math.max(take,skip);

    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];

        for (int i = 0; i < n; i++)
        Arrays.fill(dp[i], -1);
        return solve(nums,0,n,1,dp);
         
    }
}