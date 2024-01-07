import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int[] arr = new int[Integer.parseInt(input[0])];
        for (int i = 0 ; i < arr.length; i++){
            arr[i] = i+1;
        }
        int count = Integer.parseInt(input[1]);
        
        while (count-- > 0){
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]) - 1;
            int end = Integer.parseInt(line[1]) - 1;
            while (start < end){
                int tmp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = tmp;
            }
        }
        for(int i : arr){
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }
}