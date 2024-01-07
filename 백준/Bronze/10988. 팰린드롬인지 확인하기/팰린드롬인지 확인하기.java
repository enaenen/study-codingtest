import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line = br.readLine();
        StringBuilder sb = new StringBuilder(line).reverse();
        if (sb.toString().equals(line))
            bw.write("1\n");
        else
            bw.write("0\n");
       bw.flush();
        bw.close();
    }
}