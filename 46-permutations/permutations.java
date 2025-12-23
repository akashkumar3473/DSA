class Solution {

    public void backtrack(List<List<Integer>> ans, List<Integer> prem, int[] nums){
        if(prem.size()==nums.length){
            ans.add(new ArrayList<>(prem));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(prem.contains(nums[i]))
                continue;
            prem.add(nums[i]);
            backtrack(ans,prem,nums);
            prem.remove(prem.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }
}