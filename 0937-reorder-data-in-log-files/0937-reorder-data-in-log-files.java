class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        
        for (String log : logs){
            if (Character.isDigit(log.split(" ")[1].charAt(0))){
                digitLogs.add(log);
            }
            else {
                letterLogs.add(log);
            }
        }
        
        letterLogs.sort((o1, o2) -> {
            String[] o1x = o1.split(" ", 2);
            String[] o2x = o2.split(" ", 2);
            int result = o1x[1].compareTo(o2x[1]);
            if (result == 0){
                return o1x[0].compareTo(o2x[0]);
            }
            return result;
        });
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
}