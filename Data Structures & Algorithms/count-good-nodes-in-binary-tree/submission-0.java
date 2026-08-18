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

    int count = 0;

    private void countGoodNodes(TreeNode root, int max) {
        if(root == null) {
            return;
        }
        if(root.val < max) {
            countGoodNodes(root.left, max);
            countGoodNodes(root.right, max);
        } else {
            count++;
            countGoodNodes(root.left, root.val);
            countGoodNodes(root.right, root.val);
        }
    }

    public int goodNodes(TreeNode root) {
        countGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }
}