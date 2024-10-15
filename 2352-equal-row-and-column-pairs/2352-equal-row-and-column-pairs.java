class Solution {
    public int equalPairs(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++){
            int[] line = new int[n];
            for (int j = 0; j < n; j++) line[j] = grid[j][i];
            for (int k = 0; k < n; k++){
                if (Arrays.equals(grid[k], line)) answer++;
            }
        }
        return answer;
    }
}
