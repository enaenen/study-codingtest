import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int totalAnswer = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int sum = 0;
        
        while (count-- > 0){
           String[] content = br.readLine().split(" ");
            sum += (Integer.parseInt(content[0]) * Integer.parseInt(content[1]));
        }
         if (totalAnswer != sum)
            System.out.println("No");
        else
            System.out.println("Yes");
    }
}