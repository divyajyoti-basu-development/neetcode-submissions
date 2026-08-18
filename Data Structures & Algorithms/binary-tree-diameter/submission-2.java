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

    private int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recursiveMaxDia(root);
        return maxDia;
    }

    private int recursiveMaxDia(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        int leftDepth = recursiveMaxDia(node.left);
        int rightDepth = recursiveMaxDia(node.right);
        maxDia = Math.max(maxDia, leftDepth + rightDepth);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
