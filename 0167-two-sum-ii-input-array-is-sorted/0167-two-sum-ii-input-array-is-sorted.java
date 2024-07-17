class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lt = 0;
        int rt = numbers.length -1;
        while (numbers[lt] + numbers[rt] != target){
            if (numbers[lt] + numbers[rt] < target) lt++;
            else rt--;
        }
        return new int[]{++lt, ++rt};
    }
}