class Solution {
    static final int MAX_TOTAL = 10001;
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        
        for(int[] arr : dp){
            Arrays.fill(arr, MAX_TOTAL);
        }
        return calc(triangle, 0, 0, dp);
    }
    private static int calc(List<List<Integer>> triangle, int i, int j, int[][] dp){
        if (i == triangle.size()){
            return 0;
        }
        if (dp[i][j] != MAX_TOTAL){
            return dp[i][j];
        }
        int left = triangle.get(i).get(j) + calc(triangle, i+1, j, dp);
        int right = triangle.get(i).get(j) + calc(triangle, i+1, j+1, dp);
        return dp[i][j] = Math.min(left, right);
    }
}