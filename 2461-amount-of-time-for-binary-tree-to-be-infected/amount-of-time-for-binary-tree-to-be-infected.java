import java.util.*;

class Solution {

    public TreeNode solve(TreeNode root, int start, Map<TreeNode, TreeNode> parentMap) {

        if (root == null) return null;
        if (root.val == start) return root;

        TreeNode leftAns = null;
        TreeNode rightAns = null;

        if (root.left != null) {
            parentMap.put(root.left, root);
            leftAns = solve(root.left, start, parentMap);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
            rightAns = solve(root.right, start, parentMap);
        }

        if (leftAns != null) return leftAns;
        if (rightAns != null) return rightAns;

        return null;
    }

    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = solve(root, start, parentMap);

        parentMap.put(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);

        Map<TreeNode, Integer> visited = new HashMap<>();
        visited.put(startNode, 1);

        int time = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean check = false;

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                if (current.left != null && !visited.containsKey(current.left)) {
                    queue.offer(current.left);
                    visited.put(current.left, 1);
                    check = true;
                }

                if (current.right != null && !visited.containsKey(current.right)) {
                    queue.offer(current.right);
                    visited.put(current.right, 1);
                    check = true;
                }

                TreeNode parent = parentMap.get(current);

                if (parent != null && !visited.containsKey(parent)) {
                    queue.offer(parent);
                    visited.put(parent, 1);
                    check = true;
                }
            }

            if (check) time++;
        }

        return time;
    }
}