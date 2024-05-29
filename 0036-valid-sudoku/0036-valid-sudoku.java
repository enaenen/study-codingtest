class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] check = new boolean[11];

        for (int i = 0; i < board.length; i++){
            //가로
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.') continue;
                if ((check[board[i][j] -'0']))
                    return false;
                check[board[i][j]-'0'] = true;
            }
            Arrays.fill(check, false);
            //세로
            for (int j = 0; j < board.length; j++){
                if (board[j][i] == '.') continue;
                if (check[board[j][i] -'0'])
                    return false;
                check[board[j][i]-'0'] = true;
            }
            Arrays.fill(check, false);
        }

        // 3X3, 6X6, 9X9
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 3; x++){
                int y1 = (y + 1) * 3;
                int x1 = (x + 1) * 3;
                for (int i = y1 - 3; i < y1; i++){
                    for (int j = x1 - 3; j < x1; j++){
                        if (board[i][j] == '.') continue;
                        if(check[board[i][j] -'0']) return false;
                        check[board[i][j] -'0'] = true;
                    }
                }
                Arrays.fill(check, false);
            }
        }

        return true;
    }
}