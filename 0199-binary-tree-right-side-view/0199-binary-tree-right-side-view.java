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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        search(list, root, 1);
        return list;
    }
    private void search(List<Integer> list, TreeNode root, int currentLevel){
        if (root == null) return ;
        if (list.size() < currentLevel) list.add(root.val);
        search(list, root.right, currentLevel + 1);
        search(list, root.left, currentLevel + 1);
    }
}