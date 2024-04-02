import java.util.*;


class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        final int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<Position> que = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        int area = 2;
        
        for(int i = 0; i < land[0].length; i++){

            
            for (int j = 0; j < land.length; j++){
                int count = 0;
                if (land[j][i] == 1){
                    set.add(area);
                    land[j][i] = area;
                    que.offer(new Position(j,i));
                    while (!que.isEmpty()){
                        Position cur = que.poll();
                        count++;
                        
                        for (int k = 0; k < 4; k++){
                            int nextX = cur.x + dir[k][0];
                            int nextY = cur.y + dir[k][1];
                            
                            if (nextY < 0 || nextX < 0 || nextX >= land[0].length || nextY >= land.length) continue;
                            if (land[nextY][nextX] != 1) continue;
                            
                            que.offer(new Position(nextY,nextX));
                            land[nextY][nextX] = area;
                        }
                    }
                    map.put(area++, count);
                }
                else if (land[j][i] > 1){
                    set.add(land[j][i]);
                }
            
            }
            int total = 0;
            for(Integer areas : set){
                // System.out.println("areas = " + areas);
                // System.out.println("value = " + map.getOrDefault(areas, 0));
                
                total += map.getOrDefault(areas, 0);
            }
            // for (Map.Entry<Integer, Integer> val : map.entrySet()){
            //     System.out.println(val);
            // }
            // System.out.println("total = "+ total);
            // System.out.println("i = " + i);
            answer = Math.max(answer, total);
            // System.out.println();
            set.clear();
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