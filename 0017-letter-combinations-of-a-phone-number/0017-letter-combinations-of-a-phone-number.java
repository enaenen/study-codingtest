class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        
        if (digits.equals(""))
            return list;
        
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        combination(list, map, digits, new StringBuilder(), 0);
        return list;
    }
    private void combination(List<String> list, Map<Character, String> map, String digits, StringBuilder sb, int index){
        if (index == digits.length()){
            list.add(sb.toString());
            return ;
        }
        String word = map.get(digits.charAt(index));
        for (char alphabet : word.toCharArray()){
            sb.append(alphabet);
            combination(list, map, digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}