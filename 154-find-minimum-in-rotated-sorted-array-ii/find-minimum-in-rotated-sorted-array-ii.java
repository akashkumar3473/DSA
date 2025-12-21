class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // right
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;      
            } 
            // mid ans left
            else if (nums[mid] < nums[hi]) {
                hi = mid;         
            } 
            // duplicate
            else {
                hi--;              
            }
        }
        return nums[lo];
    }
}
