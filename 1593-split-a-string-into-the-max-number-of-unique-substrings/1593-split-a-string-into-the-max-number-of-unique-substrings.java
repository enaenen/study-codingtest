class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }
    public int backtrack(int start, String s, Set<String> seen){
        if (start == s.length()) return 0;
        int max = 0;
        for (int end = start + 1; end <= s.length(); end++){
            String sub = s.substring(start, end);
            if (!seen.contains(sub)){
                seen.add(sub);
                max = Math.max(max, backtrack(end, s, seen) + 1);
                seen.remove(sub);
            }
        }
        return max;
    }
}
