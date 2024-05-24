import java.util.*;

class Solution {
    public int solution(String[] maps) {
		//y, x
		int maxY = maps.length;
		int maxX = maps[0].length();
		//거리 배열 
		int[][] dist = new int[maxY][maxX];
        for (int[] d : dist){
            Arrays.fill(d, -1);
        }
        //start point 찾기
        int[] startPoint = new int[2];
        for (int i = 0; i < maps.length; i++){
            int SIndex = maps[i].indexOf("S");
            if (SIndex != -1){
                startPoint[0] = i;
                startPoint[1] = SIndex;
                break;
            }
        }
        
        dist[startPoint[0]][startPoint[1]] = 0;
        
        int startToLeverDist = bfs(maps, dist, startPoint, 'L');
        
        if (startToLeverDist == -1)
            return -1;
        
        for (int[] d : dist){
            Arrays.fill(d, -1);
        }
        dist[startPoint[0]][startPoint[1]] = startToLeverDist;
        int leverToEndDist = bfs(maps, dist, startPoint, 'E');
        return leverToEndDist;
        
    }
    private int bfs(String[] maps,int[][] dist, int[] startPoint, char end){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(startPoint);
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            
            if (maps[curY].charAt(curX) == end){
                startPoint[0] = curY;   
                startPoint[1] = curX;   
                return dist[curY][curX];
            }            
            for (int[] dir : dirs){
                int nextY = curY + dir[0];
                int nextX = curX + dir[1];
                
                if (!isValid(maps.length - 1, maps[0].length() - 1, nextY, nextX))
                    continue;
                if (maps[nextY].charAt(nextX) == 'X' 
                    || dist[nextY][nextX] != -1)
                    continue;
                
                queue.offer(new int[]{nextY, nextX});
                dist[nextY][nextX] = dist[curY][curX] + 1;
            }
        }
        
        return -1;
    }
    private boolean isValid(int maxY, int maxX, int curY, int curX){
       if (curX < 0 || curY < 0 || curX > maxX || curY > maxY) return false;
        return true;
    }
}
