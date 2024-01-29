import java.util.*;
import java.io.*;

class Main {
    static class Pair {
        int x;
        int y;
        public Pair(int y, int x){
            this.x =  x;
            this.y =  y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        
        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) -'0';
                dist[i][j] = -1;
            }
        }
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(0,0));
        dist[0][0]=0;
        int[] dx = new int[] {1,-1,0,0};
        int[] dy = new int[] {0,0,1,-1};
        while (!que.isEmpty()){
            Pair cur = que.poll();
            for(int i= 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || ny >= N || nx >= M)
                    continue;
                if (dist[ny][nx] > 0 || map[ny][nx] != 1)
                    continue;
                dist[ny][nx] = dist[cur.y][cur.x] + 1;
                que.offer(new Pair(ny,nx));
            }
        }
        System.out.println(dist[N-1][M-1]+1);
    }
}