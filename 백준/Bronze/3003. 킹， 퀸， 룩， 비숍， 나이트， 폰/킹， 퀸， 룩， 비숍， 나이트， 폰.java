import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] answer = new int[] {1,1,2,2,2,8};
        for (int i = 0; i < 6; i ++){
            bw.write(answer[i] - Integer.parseInt(input[i]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}