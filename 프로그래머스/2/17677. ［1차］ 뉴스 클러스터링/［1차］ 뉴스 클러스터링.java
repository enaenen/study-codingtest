class Solution {
    public int solution(String str1, String str2) {
        int[][] str1Count = new int[27][27];
        if (str1 == null || str1 == "" || str2 == null || str2 =="")   return 0;
        //대->소
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int total = 0;
        int mutual = 0;
        // 특수문자 삭제
        //abc+b+cdefg 는 ab bc +b b+ +c cd de ef fg
        // +b, b+, +c 삭제
        for (int i = 1; i < str1.length(); i++){
            char first = str1.charAt(i - 1);
            char second = str1.charAt(i);
            if (!Character.isAlphabetic(first) || !Character.isAlphabetic(second))
                continue;
            str1Count[first - 'a'][second - 'a']++;
            total++;
        }
        
        for (int i = 1; i < str2.length(); i++){
            char first = str2.charAt(i - 1);
            char second = str2.charAt(i);
            if (!Character.isAlphabetic(first) || !Character.isAlphabetic(second))
                continue;
            if (str1Count[first - 'a'][second - 'a'] > 0){
                str1Count[first - 'a'][second - 'a']--;
                mutual++;
            }
            total++;
        }

		int hapziphap = total - mutual;
        
        if (mutual == 0 && hapziphap == 0){
            return 65536;
        }
        
		double i = (double) mutual / (double) hapziphap;
		return (int) (i * 65536);
    }
}