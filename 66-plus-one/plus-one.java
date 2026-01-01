class Solution {
    public int[] plusOne(int[] nums) {
        final int n = nums.length;
        for(int i=n-1;i>=0;i--){
            nums[i]+=1;
            if(nums[i]<10) return nums;
            nums[i]=0;
        }
        nums = new int[n+1];
        nums[0]=1;
        return nums;
    }
}