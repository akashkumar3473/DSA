class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int start = 1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[start-1]){
                nums[start]=nums[i];
                start++;
            }
        }
        return start;
    }
}