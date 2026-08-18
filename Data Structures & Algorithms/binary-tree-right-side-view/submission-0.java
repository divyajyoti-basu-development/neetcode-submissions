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
    List<List<Integer>> levelOrderList;

    private void levelOrder(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(levelOrderList.size() >= level) {
            levelOrderList.get(level - 1).add(node.val);
        } else {
            levelOrderList.add(new ArrayList<>() {
                { add(node.val); }
            });
        }
        levelOrder(node.right, level + 1);
        levelOrder(node.left, level + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        levelOrderList = new ArrayList<>();
        levelOrder(root, 1);
        List<Integer> result = new ArrayList<>();
        levelOrderList.forEach(list -> {
            result.add(list.get(0));
        });
        return result;
    }
}
