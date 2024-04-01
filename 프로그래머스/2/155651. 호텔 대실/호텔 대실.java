import java.util.*;

class Solution {
    public void print(int[][] arr){
        for (int[] a : arr){
            for(int n : a){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    public int solution(String[][] book_time) {
        int[][] bookTimes = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++){
            String[] inTime = book_time[i][0].split(":");
            String[] outTime = book_time[i][1].split(":");
           
            bookTimes[i][0] = (Integer.parseInt(inTime[0])) * 60 + (Integer.parseInt(inTime[1]));
            bookTimes[i][1] = (Integer.parseInt(outTime[0])) * 60 + (Integer.parseInt(outTime[1])) + 10;
            
        }
        
        Arrays.sort(bookTimes, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> outTime = new PriorityQueue<>();
        outTime.add(bookTimes[0][1]);
        for (int i = 1; i < bookTimes.length; i++){
            if (outTime.peek() <= bookTimes[i][0]) outTime.poll();
            outTime.add(bookTimes[i][1]);
        }
        return outTime.size();
    }
}