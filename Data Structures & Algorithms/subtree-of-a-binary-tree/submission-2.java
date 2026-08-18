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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null) {
            return false;
        }
        if(root.val == subRoot.val && isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode parent, TreeNode child) {
        if(parent == null && child == null) {
            return true;
        }
        if(parent == null || child == null) {
            return false;
        }
        if(parent.val != child.val) {
            return false;
        }
        return isSameTree(parent.left, child.left) && isSameTree(parent.right, child.right);
    }
}
