class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> { return Integer.compare(o2[1], o1[1]); } );
        
        int current = 0;
        int amount = 0;
        int totalUnit = 0;
        while (amount < truckSize){
            if (current > boxTypes.length - 1)
                break;
            totalUnit += boxTypes[current][1];
            if (--boxTypes[current][0] == 0){
                current++;
            }
            amount++;
        }
        return totalUnit;
    }
}