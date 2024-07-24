class Solution {
    private int convert(int num, int[] mapping){
        char[] c = Integer.toString(num).toCharArray();
        for (int i = 0; i < c.length; i++) c[i] = (char)('0' + mapping[c[i] - '0']);
        return Integer.parseInt(new String(c));
    }
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        //원래순서 저장
        Map<Integer, Integer> originalMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            originalMap.put(nums[i], convert(nums[i], mapping));
        }
        Integer[] numsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsInteger, (o1, o2) -> Integer.compare(originalMap.get(o1), originalMap.get(o2)));
        for (int i = 0; i < numsInteger.length; i++) nums[i] = numsInteger[i];
        return nums;
    }        
}

