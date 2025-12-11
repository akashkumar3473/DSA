class Solution {
    void solve(List<List<Integer>> ans, List<Integer> curr, int idx, int[] n, int target, int currSum) {
        if (currSum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target) return;
        if (idx >= n.length) return;

        // take
        curr.add(n[idx]);
        solve(ans, curr, idx, n, target, currSum + n[idx]);

        // not take
        curr.remove(curr.size() - 1);
        solve(ans, curr, idx + 1, n, target, currSum);
    }

    public List<List<Integer>> combinationSum(int[] n, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(ans, curr, 0, n, target, 0);
        return ans;
    }
}
