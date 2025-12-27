class Solution {
    public void solve(List<List<Integer>> ans,List<Integer> curr,int idx, int[] n, int target, int currSum){
        if(currSum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target || idx >= n.length) return;

        for (int i = idx; i < n.length; i++) {

            //  skip duplicates
            if (i > idx && n[i] == n[i - 1]) continue;

            //  pruning
            if (currSum + n[i] > target) break;

            curr.add(n[i]);

            //  move to next index (each number used once)
            solve(ans, curr, i + 1, n, target, currSum + n[i]);

            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] n, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(n);
        solve(ans,curr,0,n,target,0);
        return ans;
    }
}