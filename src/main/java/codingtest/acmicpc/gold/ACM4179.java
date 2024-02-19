import java.util.*;
import java.lang.*;
import java.io.*;

public class ACM4179 {
    public static class Location {
        public int y;
        public int x;
        public Location(int y, int x){
            this.y = y;
            this.x = x;
         }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        char[][] map = new char[C][R];
        int[][] fireDist = new int[C][R];
        int[][] jDist = new int[C][R];

        int[] dirR = new int[] {0,0,1,-1};
        int[] dirC = new int[] {1,-1,0,0};

        Queue<Location> fireQue = new LinkedList<>();
        Queue<Location> que = new LinkedList<>();

        for (int i = 0; i < C; i++){
            String line = br.readLine();
            for(int j = 0; j < R; j++){
                map[i][j] = line.charAt(j);
                fireDist[i][j] = -1;
                jDist[i][j] = -1;
                if (map[i][j] == 'F'){
                    fireQue.offer(new Location(i,j));
                    fireDist[i][j] = 0;
                }
                if (map[i][j] == 'J'){
                    que.offer(new Location(i,j));                
                    jDist[i][j] = 1;
                }
            }
        }
        while (!fireQue.isEmpty()){
            Location cur = fireQue.poll();
            for (int i = 0; i < 4; i++){
                int nextY = cur.y + dirC[i];
                int nextX = cur.x + dirR[i];
                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C)
                    continue;
                if (map[nextY][nextX] == '#')
                    continue;
                fireQue.offer(new Location(nextY, nextX));
                fireDist[nextY][nextX] = fireDist[cur.y][cur.x] + 1;
            }
        }

        while (!que.isEmpty()){
            Location cur = que.poll();
            System.out.println("cur = " + cur.x + cur.y);
            for (int i = 0; i < 4; i++){
                int nextY = cur.y + dirC[i];
                int nextX = cur.x + dirR[i];
                if (nextX < 0 || nextY < 0) 
                    continue;
                if(nextX >= R || nextY >= C){
                    System.out.println(jDist[cur.y][cur.x] + 1);
                    return;
                }
                if (map[nextY][nextX] != '.' || fireDist[nextY][nextX] < jDist[cur.y][cur.x] + 1)
                    continue;
                jDist[nextY][nextX] =jDist[cur.y][cur.x] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
