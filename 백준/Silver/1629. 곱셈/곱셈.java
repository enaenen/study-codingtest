import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int mod = Integer.parseInt(input[2]);
        
        System.out.println(pow(a,b,mod));
    }
    static long pow(int a, int b, int mod){
        if (b == 0)
            return 1;
        long n = pow (a, b / 2, mod);
        if (b % 2 == 0)
            return n * n % mod;
        else
            return (n * n % mod) * a % mod;
    }
}