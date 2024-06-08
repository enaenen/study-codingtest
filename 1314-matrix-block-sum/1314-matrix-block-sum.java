class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] sums = new int[mat.length + 1][mat[0].length + 1];
        Arrays.fill(sums[0], 0);

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                sums[i + 1][j + 1] = mat[i][j] + sums[i][j + 1] + sums[i + 1][j] - sums[i][j]; 
            }
        }

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(mat.length - 1, i + k);
                int c1 = Math.max (0, j - k);
                int c2 = Math.min(mat[0].length - 1, j + k);

                mat[i][j] = sums[r2 + 1][c2 + 1] - sums[r1][c2 + 1] - sums[r2 + 1][c1] + sums[r1][c1];
            }
        }

        return mat;
    }
}