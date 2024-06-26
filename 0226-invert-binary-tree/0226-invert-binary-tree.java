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
    public TreeNode invertTree(TreeNode root) {
        childSwap(root);
        return root;
    }
    private void childSwap(TreeNode root){
        if (root == null) return;

        if (root.right == null){
            root.right = root.left;
            root.left = null;
        }
        else if (root.left == null){
            root.left = root.right;
            root.right = null;
        }
        else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        childSwap(root.left);
        childSwap(root.right);
    }
}