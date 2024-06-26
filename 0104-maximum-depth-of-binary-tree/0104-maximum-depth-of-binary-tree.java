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
    public int maxDepth(TreeNode root) {
        return search(root, 0);
    }
    private int search(TreeNode root, int currentLevel){
        if (root == null) return currentLevel;
        int fromLeft = search(root.left, currentLevel + 1);
        int fromRight = search(root.right, currentLevel + 1);
        return Math.max(fromLeft, fromRight);
    }
}