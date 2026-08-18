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

    int maxDia;

    private int getMaxHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int leftHeight = 1 + getMaxHeight(root.left);
        int rightHeight = 1 + getMaxHeight(root.right);
        maxDia = Math.max(maxDia, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxHeight(root);
        return maxDia;
    }
}
