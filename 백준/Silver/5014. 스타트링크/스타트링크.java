import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int F = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int G = Integer.parseInt(input[2]);

        int[] dir = new int[2];
        dir[0] = Integer.parseInt(input[3]);
        dir[1] = -Integer.parseInt(input[4]);

        boolean[] visited = new boolean[F+1];
        Queue<Integer> que = new LinkedList<>();
        int[] count = new int[F+1];
        que.offer(S);
        visited[S] = true;
        

        while (!que.isEmpty()){
            int cur = que.poll();
            if (cur == G){
                System.out.println(count[cur]);
                return ;
            }
            for (int i = 0; i < 2; i ++){
                int next = cur + dir[i];
                if(next < 1 || next > F)
                    continue;
                if(!visited[next]){
                    que.offer(next);
                    visited[next] = true;
                    count[next] = count[cur] + 1;
                }
            }
        }
        System.out.println("use the stairs");
    }
}