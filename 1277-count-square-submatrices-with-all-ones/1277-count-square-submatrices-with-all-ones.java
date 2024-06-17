class Solution {
    public int countSquares(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (0 < matrix[i][j] && 0 < i && 0 < j){
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
              sum += matrix[i][j];
            }
        }
        return sum;
    }
}