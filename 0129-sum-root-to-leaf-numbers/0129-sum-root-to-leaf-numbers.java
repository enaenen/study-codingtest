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
    public int search(int prevTotal, TreeNode node){
        if (node.left == null && node.right == null){
            return prevTotal + node.val;
        }
        int currentTotal = (prevTotal + node.val) * 10;
        int leftSum = 0;
        int rightSum = 0;
        if (node.left != null){
            leftSum = search(currentTotal, node.left);
        }
        if (node.right != null){
            rightSum = search(currentTotal, node.right);
        }
        return leftSum+rightSum;
    }

    public int sumNumbers(TreeNode root) {
        return search(0, root);
    }
}