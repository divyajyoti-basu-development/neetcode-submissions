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

    private int getHeight(TreeNode node) {
        if(node == null) {
            return -1;
        }
        int leftHeight = 1 + getHeight(node.left);
        int rightHeight = 1 + getHeight(node.right);
        return Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }        
        int leftHeight = 1 + getHeight(root.left);
        int rightHeight = 1 + getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
