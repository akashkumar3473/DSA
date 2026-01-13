class Solution {
    int[] dp;
    public int solve(int[] coins, int amount) {
        // Base cases
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        // Memo check
        if (dp[amount] != -1) return dp[amount];

        int minCoins = Integer.MAX_VALUE;

        // Try each coin
        for (int coin : coins) {
            int res = solve(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        return dp[amount] = minCoins;
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = solve(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
