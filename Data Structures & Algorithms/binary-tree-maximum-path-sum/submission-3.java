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

    int result;

    private int checkMaxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSum = checkMaxSum(root.left);
        int rightSum = checkMaxSum(root.right);
        result = Math.max(result, root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0));
        return root.val + Math.max(0, Math.max(leftSum, rightSum));
    }

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        checkMaxSum(root);
        return result;
    }
}