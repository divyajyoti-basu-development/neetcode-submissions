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
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
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