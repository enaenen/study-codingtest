class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Deque<int[]> que = new LinkedList<>();
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        if (board[click[0]][click[1]] == 'E'){
            que.offer(new int[] {click[0], click[1]});
            while (!que.isEmpty()){
                int[] curClick = que.poll();
                int count = 0;
                for (int[] direction : dir){
                    int nextRow = curClick[0] + direction[0];
                    int nextCol = curClick[1] + direction[1];
                    if (nextRow < 0 || nextCol < 0 || nextRow > board.length -1 || nextCol > board[0].length - 1){
                        continue;
                    }
                    if (board[nextRow][nextCol] == 'M'){
                        count++;
                    }
                }
                if (0 < count){
                    board[curClick[0]][curClick[1]] = (char)(count + '0');
                    continue;
                }
                for (int[] direction : dir){
                    board[curClick[0]][curClick[1]] = 'B';
                    int nextRow = curClick[0] + direction[0];
                    int nextCol = curClick[1] + direction[1];
                    if (nextRow < 0 || nextCol < 0 || nextRow > board.length -1 || nextCol > board[0].length - 1){
                        continue;
                    }
                    if (board[nextRow][nextCol] == 'E'){
                        que.offer(new int[] {nextRow, nextCol});
                        board[nextRow][nextCol] = 'B';
                    }
                }
            }
        }
        return board;
    }
}