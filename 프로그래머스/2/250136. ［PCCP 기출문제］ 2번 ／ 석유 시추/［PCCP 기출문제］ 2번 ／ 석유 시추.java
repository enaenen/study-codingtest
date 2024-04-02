import java.util.*;


class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[land.length][land[0].length];
        Queue<Position> que = new LinkedList<>();
        
        for(int i = 0; i < land[0].length; i++){
            int count = 0;
            visited = new boolean[land.length][land[0].length];
            for (int j = 0; j < land.length; j++){
                if (land[j][i] == 1 && !visited[j][i]){
                    que.offer(new Position(j,i));
                    while (!que.isEmpty()){
                        Position cur = que.poll();
                        visited[cur.y][cur.x] = true;
                        count++;
                        
                        for (int k = 0; k < 4; k++){
                            int nextX = cur.x + dir[k][0];
                            int nextY = cur.y + dir[k][1];
                            
                            if (nextY < 0 || nextX < 0 || nextX >= land[0].length || nextY >= land.length) continue;
                            if (visited[nextY][nextX] || land[nextY][nextX] == 0) continue;
                            
                            que.offer(new Position(nextY,nextX));
                            visited[nextY][nextX] =true;
                        }
                    }
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
    
    class Position {
        int x;
        int y;
        public Position(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
}
/*
	[0, 0, 0, 1, 1, 1, 0, 0], 
    [0, 0, 0, 0, 1, 1, 0, 0], 
    [1, 1, 0, 0, 0, 1, 1, 0], 
    [1, 1, 1, 0, 0, 0, 0, 0], 
    [1, 1, 1, 0, 0, 0, 1, 1]
 */