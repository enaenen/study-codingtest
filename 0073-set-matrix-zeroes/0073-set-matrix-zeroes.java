class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean[] zeroCol = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++){
            boolean isRowZero = false;
            for (int j = 0; j < matrix[0].length; j++ ){
                if(matrix[i][j] == 0){
                    zeroCol[j] = true;
                    isRowZero = true;
                }
            }
            if (isRowZero){
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (zeroCol[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}