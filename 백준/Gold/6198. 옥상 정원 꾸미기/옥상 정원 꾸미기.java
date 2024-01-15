import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long buildings = Long.parseLong(br.readLine());
        Stack<Long> stack = new Stack<>();
        long previous = 0;
        long total = 0;
        while (buildings-- > 0){
            long current = Long.parseLong(br.readLine());
            if (current >= previous){
                while (!stack.isEmpty() && stack.peek() <= current){
                    stack.pop();
                }
            }
            total += stack.size();
            stack.push(current);
            previous = current;
        }
        System.out.println(total);
    }
}