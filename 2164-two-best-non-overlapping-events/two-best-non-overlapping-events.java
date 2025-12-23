class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
         PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int maxVal = 0;
        int ans = 0;

        for (int[] e : events) {
            int start = e[0], end = e[1], val = e[2];
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                maxVal = Math.max(maxVal, pq.poll()[1]);
            }
            ans = Math.max(ans, maxVal + val);

            // Add current event
            pq.offer(new int[]{end, val});
        }
        return ans;
    }
}