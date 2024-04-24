class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String remakedWord = new String(arr);
            map.putIfAbsent(remakedWord, new ArrayList<>());
            map.get(remakedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}