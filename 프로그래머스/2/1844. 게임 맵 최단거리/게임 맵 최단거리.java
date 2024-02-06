import java.util.*;

class Solution {
    class Pair {
        int x;
        int y;
        public Pair(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        
        // Stack<Pair> stack = new Stack<>();
        Queue<Pair> stack = new LinkedList<>();
        int[][] dist = new int[maps.length][maps[0].length];
        int[] dx = new int[] {1,-1,0,0};
        int[] dy = new int[] {0,0,-1,1};
        
        stack.offer(new Pair(0, 0));
        dist[0][0] = 1;
        while (!stack.isEmpty()){
            Pair p = stack.poll();
            int curX = p.x;
            int curY = p.y;
            for (int i = 0; i < 4; i++){
                int nX = curX + dx[i];
                int nY = curY + dy[i];
                
                if (nX < 0 || nY < 0 || nX >= maps[0].length || nY >= maps.length)
                    continue;
                if (maps[nY][nX] != 1 || dist[nY][nX] > 0)
                    continue;
                stack.offer(new Pair(nY, nX));
                dist[nY][nX] = dist[curY][curX] + 1;
            }
        }
        answer = dist[maps.length - 1][maps[0].length - 1];

        if (answer == 0)
            return -1;    
        return answer;
    }
}