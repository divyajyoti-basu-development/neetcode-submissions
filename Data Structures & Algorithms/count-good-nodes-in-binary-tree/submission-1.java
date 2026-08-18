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
    int count;

    private void checkGoodNode(TreeNode root, int pathMax) {
        if(root == null) {
            return;
        }
        if(root.val >= pathMax) {
            count++;
            pathMax = root.val;
        }
        checkGoodNode(root.left, pathMax);
        checkGoodNode(root.right, pathMax);
    }

    public int goodNodes(TreeNode root) {        
        checkGoodNode(root, -200);
        return count;
    }
}
