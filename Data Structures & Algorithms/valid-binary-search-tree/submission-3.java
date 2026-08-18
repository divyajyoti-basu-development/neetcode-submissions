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

    public boolean isValidSubTree(TreeNode node, int minVal, int maxVal) {
        if(node == null) {
            return true;
        }
        System.out.println("1 At node: " + node.val);
        if(node.val <= minVal || node.val >= maxVal) {
            return false;
        } 
        System.out.println("2 At node: " + node.val);       
        return isValidSubTree(node.left, minVal, node.val) && isValidSubTree(node.right, node.val, maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }    
        return isValidSubTree(root.left, Integer.MIN_VALUE, root.val) && isValidSubTree(root.right, root.val, Integer.MAX_VALUE);
    }
}
