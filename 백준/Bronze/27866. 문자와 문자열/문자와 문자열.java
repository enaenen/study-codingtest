import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line= br.readLine();
        System.out.println(line.charAt(Integer.parseInt(br.readLine())-1));
    }
}