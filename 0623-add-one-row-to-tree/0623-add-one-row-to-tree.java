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
    private void search(TreeNode curNode, int val, int depth, int curDepth){
        if (curNode == null) 
            return;
        if (curDepth == (depth - 1)){
            curNode.left = new TreeNode(val, curNode.left, null);
            curNode.right = new TreeNode(val, null, curNode.right);
            return ;
        }
        search(curNode.left, val, depth, curDepth+1);
        search(curNode.right, val, depth, curDepth+1);
    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode newNode = new TreeNode(val, root, null); 
            return newNode;
        }
        search(root, val, depth, 1);
        return root;
    }
}