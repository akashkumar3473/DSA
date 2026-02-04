class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int i=0, j=0;
        int ans = Integer.MAX_VALUE;
        while(j<n){
            sum += nums[j];
            while(sum>=target){
                sum -= nums[i];
                ans = Math.min(ans,j-i+1);
                i++;
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}