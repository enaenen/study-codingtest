class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) ->
            Integer.compare(a[0] - a[1], b[0] - b[1])
        );
        int total = 0;
        int limit = costs.length / 2;
        for (int i = 0; i < costs.length; i++){
            total += costs[i][i / limit];
        }
        return total;
    }
}