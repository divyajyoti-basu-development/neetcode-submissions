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

    private List<List<Integer>> result;

    private void levelOrder(int level, TreeNode root) {
        
        if(root == null) {
            return;
        }

        if(result.size() >= level) {
            result.get(level - 1).add(root.val);
        } else {
            result.add(new ArrayList<>(List.of(root.val)));
        }

        levelOrder(level + 1, root.left);
        levelOrder(level + 1, root.right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        levelOrder(1, root);
        return result;
    }
}