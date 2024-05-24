class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String numString : s.split(" ")){
            int num = Integer.parseInt(numString);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min+" "+max;
    }
}