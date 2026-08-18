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

    private Map<TreeNode, Integer> memo = new HashMap<>();

    private int getTreeHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(memo.containsKey(root)) {
            return memo.get(root);
        }
        int leftDepth = getTreeHeight(root.left);
        int rightDepth = getTreeHeight(root.right);
        memo.put(root, 1 + Math.max(leftDepth, rightDepth));
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = getTreeHeight(root.left);
        int rightDepth = getTreeHeight(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
