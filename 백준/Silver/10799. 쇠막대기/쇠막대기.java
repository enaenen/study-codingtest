import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int total = 0;
        char prev = 'x';
        for (char c : line.toCharArray()){
            if (c == '('){
                total++;
                stack.push(c);
            }
            else if (c == ')'){
                stack.pop();
                if (prev == '('){
                    total--;
                    total += stack.size();
                }
            }
            prev = c;
        }
        System.out.println(total);
    }
}