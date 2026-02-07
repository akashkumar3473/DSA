class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count =0;
        int pro = 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0) count++;
            if(nums[i]!=0) pro *=nums[i];

        }
        int ans[] = new int[n];
        if(count>1) return ans;

        if(count==1){
            for(int i=0;i<n;i++){
                if(nums[i]==0){
                    ans[i]=pro;
                    return ans;
                }
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=pro/nums[i];
        }
        return ans;
    }
}