class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] arr : dp){
            Arrays.fill(arr, 10001);
        }
        return goingDown(triangle, dp, 0, 0);
        
    }
    public int goingDown(List<List<Integer>> triangle, int[][] dp, int i, int j){
        if (i == triangle.size()) return 0;
        if (dp[i][j] != 10001) return dp[i][j];
        int left = triangle.get(i).get(j) + goingDown(triangle, dp, i + 1, j);
        int right = triangle.get(i).get(j) + goingDown(triangle, dp, i + 1, j + 1);
        return dp[i][j] = Math.min(left, right);
    }
}