class Solution {
    Boolean[][] dp;
    int n;
    public Boolean solve(int i, int[] arr, int target){
        if(i==n){
            if(target==0) return true;
            else return false;
        }
        if(dp[i][target]!=null) return dp[i][target];
        boolean skip = solve(i+1,arr,target);
        
        if(target-arr[i]<0) return skip;
        
        boolean take = solve(i+1,arr,target-arr[i]);
        
        return dp[i][target] = take || skip;
    }
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int ele : arr) sum += ele;
        if(sum%2!=0) return false;
        int target = sum/2;
        n = arr.length;
        dp = new Boolean[n][target+1];
        return solve(0,arr,target);
    }
}