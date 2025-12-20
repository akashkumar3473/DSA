class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0; int hi = nums.length-1;
         while(hi>=lo){
            int mid = lo+(hi-lo)/2;
         
long leftval = (mid==0)? Long.MIN_VALUE :(long)nums[mid-1];
long rightval= (mid==nums.length-1)? Long.MIN_VALUE:(long)nums[mid+1];
           
            if(nums[mid]>leftval  && nums[mid]>rightval){
                return mid;
            }
            else if(nums[mid]<rightval ){
                lo =mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return -1;
        
      }
}