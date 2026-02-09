class Solution {
    public static void solve(TreeNode root, int target,List<List<Integer>> ans, List<Integer> temp) {
        if (root == null) return;

        temp.add(root.val);

        // Leaf node
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                ans.add(new ArrayList<>(temp)); 
            }
        } else {
            solve(root.left, target - root.val, ans, temp);
            solve(root.right, target - root.val, ans, temp);
        }

        temp.remove(temp.size() - 1); // backtracking
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(root, targetSum, ans, temp); 
        return ans;
    }
}
