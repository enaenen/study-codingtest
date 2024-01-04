import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] basket = new int[N];
        for (int i = 1; i < N + 1; i++) {
            basket[i - 1] = i;
        }
        for (int i = 0; i < M; i++) {
            String[] instructions = br.readLine().split(" ");
            int indexA = Integer.parseInt(instructions[0]) - 1;
            int indexB = Integer.parseInt(instructions[1]) - 1;
            int tmp = basket[indexA];
            basket[indexA] = basket[indexB];
            basket[indexB] = tmp;
        }
        for (int i : basket) {
            System.out.print(i + " ");
        }
    }
}