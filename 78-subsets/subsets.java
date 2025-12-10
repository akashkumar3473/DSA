class Solution {
    void solve(List<List<Integer>> ans, List<Integer> curr,int i, int[] nums){
        // take
        if(i>=nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);  
        solve(ans,curr,i+1,nums);
        curr.remove(curr.size()-1);
        solve(ans,curr,i+1,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(ans,curr,0,nums); 
        return ans;
    }
    
}