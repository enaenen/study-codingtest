import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[1]);
        int[] basket = new int[Integer.parseInt(input[0])];

        for (int i = 0; i < m; i++){
            String[] ballInput = br.readLine().split(" ");
            int start = Integer.parseInt(ballInput[0]);
            int end = Integer.parseInt(ballInput[1]);
            int ballNumber = Integer.parseInt(ballInput[2]);
            for (int j = start-1; j < end; j++){
                basket[j] = ballNumber;
            }
        }
        for (int i : basket) {
            System.out.print(i + " ");
        }
    }
}