class Solution {
    private int findFirst(int[] nums, int target){
        int n = nums.length;
        int lo =0, hi =n-1;
        int ans =-1;
        while(lo<=hi){
            int mid  = lo+(hi-lo)/2;
            if(nums[mid]==target) {
                ans = mid;
                hi =mid-1;
            }
            
            else if(nums[mid]<target) {
                lo = mid+1;
            } 
            else {
                hi = mid-1;
            } 

        }
        return ans;
    }
    private int findLast(int[] nums, int target){
        int n = nums.length;
        int lo =0, hi =n-1;
        int ans =-1;
        while(lo<=hi){
            int mid  = lo+(hi-lo)/2;
            if(nums[mid]==target) {
                ans = mid;
                lo =mid+1;
            }
            
            else if(nums[mid]<target) {
                lo = mid+1;
            } 
            else {
                hi = mid-1;
            } 

        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums,target);
        int last = findLast(nums,target);
        return new int[]{first,last};

    }
    
}