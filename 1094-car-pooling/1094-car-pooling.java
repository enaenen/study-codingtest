class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] map = new int[1001];

        for (int[] trip : trips){
            map[trip[1]] += trip[0];
            map[trip[2]] -= trip[0];
        }

        int passengers = 0;
        for (int road : map){
            passengers += road;
            if (capacity < passengers)
                return false;
        }
        return true;
    }
}