class Solution {
    public boolean solve(int i,boolean[] vis, int[] arr){
        int n = arr.length;
       if(i<0 || i>=n) return false;
       if(vis[i]) return false;
       if(arr[i]==0) return true;
       vis[i] = true;

       return solve(i+arr[i],vis,arr) || solve(i-arr[i],vis,arr); 
    }
    public boolean canReach(int[] arr, int start) {
       int n=arr.length;
       boolean[] vis = new boolean[n];
       return solve(start,vis,arr);
    }
}