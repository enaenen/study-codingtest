class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[0] - o1[1], o2[0] - o2[1]));
        int total = 0;
        int limit = costs.length / 2;
        for (int i = 0; i < costs.length; i++){
            total += costs[i][i / limit];
        }
        return total;
    }
}