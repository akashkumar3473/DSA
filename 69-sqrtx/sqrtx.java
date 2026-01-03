class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;   // handle edge case

        int lo = 1, hi = x;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid == x / mid) return mid;
            if (mid > x / mid) hi = mid - 1;
            else lo = mid + 1;
        }
        return hi;
    }
}
