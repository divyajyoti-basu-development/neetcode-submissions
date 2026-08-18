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
    private int result = 0;
    private int dfsDiameter(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftMax = dfsDiameter(root.left);
        int rightMax = dfsDiameter(root.right);
        result = Math.max(result, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        dfsDiameter(root);
        return result;
    }
}