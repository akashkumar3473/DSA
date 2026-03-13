class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        
        long left = 1;
        long right = 0;
        for (int w : workerTimes) {
            right = Math.max(right, (long) w * mountainHeight * (mountainHeight + 1) / 2);
        }
        
        long ans = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canReduce(mountainHeight, workerTimes, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canReduce(int targetHeight, int[] workerTimes, long maxTime) {
        long totalHeightReduced = 0;
        for (int w : workerTimes) {
            long limit = 2 * maxTime / w;
            long x = (long) ((-1 + Math.sqrt(1 + 4 * limit)) / 2);
            totalHeightReduced += x;
            
            if (totalHeightReduced >= targetHeight) return true;
        }
        return totalHeightReduced >= targetHeight;
    }
}