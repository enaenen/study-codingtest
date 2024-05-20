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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return check(root.left, Long.MIN_VALUE, root.val) && check(root.right, root.val, Long.MAX_VALUE);
    }
    public boolean check(TreeNode cur, long min, long max){
        if (cur == null)
            return true;
        if (cur.val <= min || cur.val >= max)
            return false;
        return check(cur.left, min, cur.val) && check(cur.right, cur.val, max);
    }
}