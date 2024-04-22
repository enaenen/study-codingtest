class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> { return o1[2] - o2[2]; });
        Arrays.sort(trips, (o1, o2) -> {return o1[1] - o2[1];});
        int passenger = 0;
        
        for (int i = 0; i < trips.length; i++){
            int[] current = trips[i];
            passenger += current[0];

            while (!que.isEmpty() && que.peek()[2] <= current[1]){
                passenger -= que.poll()[0];
            }
            
            if (passenger > capacity){
                return false;
            }
            que.offer(current);
        }
        return true;
    }
}