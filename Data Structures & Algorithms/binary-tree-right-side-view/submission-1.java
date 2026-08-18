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

    private List<List<Integer>> levelOrderList = new ArrayList<>();

    private void recursiveLevelOrder(TreeNode node, int level) {
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
        recursiveLevelOrder(node.left, level + 1);
        recursiveLevelOrder(node.right, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        recursiveLevelOrder(root, 1);
        List<Integer> result = new ArrayList<>();
        for(List<Integer> levelList : levelOrderList) {
            result.add(levelList.get(levelList.size() - 1));
        }
        return result;
    }
}
