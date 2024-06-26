class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuelTank=0;
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost)
            return -1;
        for (int i = 0; i < gas.length; i++){
            fuelTank += gas[i] - cost[i];
            if (fuelTank < 0){
                start = i + 1;
                fuelTank = 0;
            }
        }
        return start;
    }
}