class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> middle = new ArrayList<int[]>();
        
        for (int[] interval : intervals){
            if (interval[1] < newInterval[0]){
                middle.add(interval);
            }
            else if (interval[0] > newInterval[1]){
                middle.add(newInterval);
                newInterval = interval;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        middle.add(newInterval);
        return middle.toArray(new int[middle.size()][]);
    }
}