class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007;

        long[] dp = new long[n + 1]; 
        long[] pref = new long[n + 1];

        dp[0] = 1;          // One way to partition empty prefix
        pref[0] = 1;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int j = 0;

        for (int i = 0; i < n; i++) {

            // Maintain monotonic decreasing deque for max
            while (!maxQ.isEmpty() && nums[i] > maxQ.peekLast())
                maxQ.pollLast();
            maxQ.addLast(nums[i]);

            // Maintain monotonic increasing deque for min
            while (!minQ.isEmpty() && nums[i] < minQ.peekLast())
                minQ.pollLast();
            minQ.addLast(nums[i]);

            // Shrink window if invalid
            while (!maxQ.isEmpty() && !minQ.isEmpty() 
                   && maxQ.peekFirst() - minQ.peekFirst() > k) {

                if (nums[j] == maxQ.peekFirst()) maxQ.pollFirst();
                if (nums[j] == minQ.peekFirst()) minQ.pollFirst();
                j++;
            }

            // dp[i+1] = sum(dp[j] ... dp[i])
            long total = pref[i];
            long subtract = (j > 0 ? pref[j - 1] : 0);

            dp[i + 1] = (total - subtract + MOD) % MOD;

            // update prefix sum
            pref[i + 1] = (pref[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
