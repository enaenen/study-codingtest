class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrows = 1;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int min = points[0][1];
        for (int i = 1; i < points.length; i++){
            if (min < points[i][0]){
                arrows++;
                min = points[i][1];
            }
        }
        return arrows;
    }
}