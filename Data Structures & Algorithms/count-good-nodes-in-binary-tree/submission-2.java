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

    private int goodNodesCount;

    private void checkGoodNode(TreeNode node, int largest) {
        if(node == null) {
            return;
        }
        if(node.val >= largest) {
            goodNodesCount++;
            largest = node.val;
        }
        checkGoodNode(node.left, largest);
        checkGoodNode(node.right, largest);
    }

    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }    
        checkGoodNode(root, root.val);
        return goodNodesCount;
    }

}
