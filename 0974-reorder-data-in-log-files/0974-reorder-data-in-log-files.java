class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // logs 에서 Letter log & Digit logs 분리
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs){
            if (Character.isDigit(log.split(" ")[1].charAt(0))){
                digitLogs.add(log);
            }
            else{
                letterLogs.add(log);
            }
        }


        // letter logs sort
        Collections.sort(letterLogs, (o1, o2) -> {
            String[] o1s = o1.split(" ", 2);
            String[] o2s = o2.split (" ", 2);
            int result = o1s[1].compareTo(o2s[1]);
            if (result == 0){
                return o1s[0].compareTo(o2s[0]);
            }
            return result;
        });
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
}