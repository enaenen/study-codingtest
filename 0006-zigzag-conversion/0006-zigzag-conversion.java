class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
		List<Character>[] board = new ArrayList[numRows];

		for (int i = 0; i < numRows; i++) {
			board[i] = new ArrayList();
		}
		int idx = 0;
		boolean reverse = false;
		for (int i = 0; i < s.length(); i++) {
			if (idx == numRows - 1) {
				reverse = true;
			} else if (idx == 0) {
				reverse = false;
			}
			if (reverse) {
				board[idx--].add(s.charAt(i));
			} else {
				board[idx++].add(s.charAt(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (List<Character> b : board) {
			for (char c : b) {
				sb.append(c);
			}
		}
        return sb.toString();
	}
}
