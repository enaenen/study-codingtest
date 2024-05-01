class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            if (e.getValue() == 1)
                return e.getKey();
        }
        return -1;
    }
}