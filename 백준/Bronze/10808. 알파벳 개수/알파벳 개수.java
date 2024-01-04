import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        char[] word = br.readLine().toCharArray();
        for(char c : word){
            alphabet[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int n : alphabet){
            sb.append(n + " ");
        }
        System.out.println(sb);
    }
}