class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] nodeArray = new TreeNode[100001];
        boolean[] isChild = new boolean[100001];

        for (int[] desc : descriptions){
            if (nodeArray[desc[0]] == null) nodeArray[desc[0]] = new TreeNode(desc[0]);

            if (nodeArray[desc[1]] == null) nodeArray[desc[1]] = new TreeNode(desc[1]);

            if (desc[2] == 1) nodeArray[desc[0]].left = nodeArray[desc[1]];
            else nodeArray[desc[0]].right = nodeArray[desc[1]];
            
            isChild[desc[1]] = true;
        }
        for (int[] desc : descriptions){
            if (!isChild[desc[0]]) return nodeArray[desc[0]];
        }
        return null;
    }
}