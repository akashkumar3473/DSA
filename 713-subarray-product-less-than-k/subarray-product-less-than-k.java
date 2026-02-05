class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k<=1) return 0;
        int ans =0;
        int i=0, j=0;
        long pro = 1;
        while(j<n){
            pro *= nums[j];
            while(pro>=k){
                pro = pro/nums[i];
                i++;
            }
            ans = ans + (j-i+1);
            j++;
        }
        return ans;
    }
}