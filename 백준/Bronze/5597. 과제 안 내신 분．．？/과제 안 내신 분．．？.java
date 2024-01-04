import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException{
        int[] board = new int[30];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 28; i++){
            int studentNumber = Integer.parseInt(br.readLine()) - 1;
            board[studentNumber] = 1;
        }
        for (int i = 1; i <31 ;i++){
            if (board[i - 1] == 0){
                System.out.println(i);
            }
        }
    }
}