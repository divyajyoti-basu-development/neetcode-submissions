/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode, Integer> memo = new HashMap<>();
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(memo.containsKey(root)) {
            return memo.get(root);
        }
        int result = 1 + Math.max(dfs(root.left), dfs(root.right));
        memo.put(root, result);
        return result;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        boolean isBalancedAtSelf = Math.abs(leftHeight - rightHeight) <= 1 ? true : false;
        return isBalancedAtSelf && isBalanced(root.left) && isBalanced(root.right);
    }
}