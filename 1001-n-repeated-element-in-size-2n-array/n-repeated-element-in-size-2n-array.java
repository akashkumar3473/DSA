class Solution {
    public int repeatedNTimes(int[] nums) {
        final int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return n;
    }
}