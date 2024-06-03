class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[1001];
        for (int[] box : boxTypes){
            count[box[1]] += box[0];
        }
        int totalUnit = 0;
        for (int i = 1000; -1 < i; i--){
            if (count[i] <= truckSize ){
                totalUnit += i * count[i];
                truckSize -= count[i];
            }
            else if (0 < count[i]){
                totalUnit += i * truckSize;
                return totalUnit;
            }
        }
        
        return totalUnit;
    }
}