class Solution {
    public int levels(TreeNode root){
        if(root==null) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        return 1 + Math.max(leftLevels,rightLevels);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int diff = Math.abs(levels(root.left) - levels(root.right));
        if(diff>1) return false;
        boolean lst = isBalanced(root.left);
        if(lst==false) return false;
        boolean rst = isBalanced(root.right);
        if(rst==false) return false;
        return true;
    }
}