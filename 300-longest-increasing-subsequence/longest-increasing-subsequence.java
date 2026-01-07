class Solution {
    int[][] dp;

    public int solve(int[] nums, int i, int n, int prev) {
        if (i >= n) return 0;

        if (dp[i][prev + 1] != -1)
            return dp[i][prev + 1];

        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(nums, i + 1, n, i);
        }

        int skip = solve(nums, i + 1, n, prev);

        return dp[i][prev + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];   // changed from [n][2]

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0, n, -1);  
    }
}
