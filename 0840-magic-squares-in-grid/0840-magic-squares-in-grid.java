class Solution {
    public boolean isValid(int[][] grid, int y, int x){

        //num duplicattion check
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int n = grid[i + y][j + x];
                if (n < 1 || n > 9 || visited[n]) return false;
                visited[n] = true;
            }
        }

        int sum = grid[y][x] + grid[y][x + 1] + grid[y][x + 2];

        for (int i = 0; i < 3; i++){
            if (sum != grid[i + y][x] + grid[i + y][x + 1] + grid[i + y][x + 2]) return false;
        }


        for (int i = 0; i < 3; i++){
            if (sum != grid[y][x + i] + grid[y + 1][x + i] + grid[y + 2][x + i]) return false;
        }

        if (sum != grid[y][x] + grid[y + 1][x + 1] + grid[y + 2][x + 2]) return false;
        if (sum != grid[y + 2][x] + grid[y + 1][x + 1] + grid[y][x + 2]) return false;

        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int answer = 0;
        int y  = grid.length;
        int x  = grid[0].length;

        for (int i = 0; i < y - 2; i++) {
            for (int j = 0; j < x - 2; j++) {
                if (isValid(grid, i, j)) answer++;
            }
        }
        
        return answer;
    }
}