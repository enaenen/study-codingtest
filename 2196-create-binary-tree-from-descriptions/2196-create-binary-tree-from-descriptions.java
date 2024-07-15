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

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Map<Integer, Integer> inversion = new HashMap<>();
        
        for (int[] nodeInfo : descriptions){
            int parentVal = nodeInfo[0];
            int curVal = nodeInfo[1];

            TreeNode currentNode = nodeMap.getOrDefault(curVal, new TreeNode(curVal));
            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));

            int isLeft = nodeInfo[2];
            if (isLeft == 1) parentNode.left = currentNode;
            else parentNode.right = currentNode;

            nodeMap.put(parentVal, parentNode);
            nodeMap.put(curVal, currentNode);
            inversion.put(curVal, parentVal);
        }
        TreeNode node = nodeMap.get(descriptions[0][0]);
        while (inversion.containsKey(node.val)){
            int next = inversion.get(node.val);
            node = nodeMap.get(next);
        }
        return node;
    }
}