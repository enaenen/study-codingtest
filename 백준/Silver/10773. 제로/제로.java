import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        while (k-- > 0){
            int n = Integer.parseInt(br.readLine());
            if (n == 0 && !stack.isEmpty()){
                stack.pop();
                continue;
            }
            stack.push(n);            
        }
        long total = 0;
        while (!stack.isEmpty()){
            total += stack.pop();
        }
        System.out.println(total);
    }
}