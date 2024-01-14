import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        int total = 0;
        int memory = 1;
        Stack<Character> openOnly = new Stack<>();
        for (int i = 0; i < line.length; i++){
            if (line[i] == '('){
                memory *= 2;
                openOnly.push(line[i]);
            }
            else if (line[i] == '['){
                memory *= 3;
                openOnly.push(line[i]);
            }
            else if (line[i] == ')'){
                if (openOnly.empty() || openOnly.pop() != '('){
                    System.out.println(0);
                    return;
                }
                if (line[i-1] == '('){
                    total += memory;
                }
                memory /= 2;
            }
            else { // line[i] == ']'
                if (openOnly.empty() || openOnly.pop() != '['){
                    System.out.println(0);
                    return;
                }
                if (line[i-1] == '['){
                    total += memory;
                }
                memory /=3;
            }
        }
        if (!openOnly.empty()){
            System.out.println(0);
            return;
        }
        System.out.println(total);
    }
}