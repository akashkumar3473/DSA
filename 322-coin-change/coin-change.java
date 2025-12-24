import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {

        if (amount == 0) return 0;

        int[] minCoinsDP = new int[amount + 1];
        Arrays.fill(minCoinsDP, Integer.MAX_VALUE);

        minCoinsDP[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE) {
                    minCoinsDP[i] = Math.min(minCoinsDP[i],1 + minCoinsDP[i - coin]);
                }
            }
        }

        return minCoinsDP[amount] == Integer.MAX_VALUE ? -1 : minCoinsDP[amount];
    }
}
