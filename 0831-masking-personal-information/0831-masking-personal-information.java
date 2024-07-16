class Solution {
    public String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        String[] splited;
        if (s.contains("@")){
            splited = s.split("@");
            sb.append(splited[0].toLowerCase());
            sb.replace(1, splited[0].length() - 1, "*****");
            sb.append("@");
            sb.append(splited[1].toLowerCase());
        }
        else{
            s = s.replaceAll("[\\+\\-\\(\\)\\s]", "");
            String[] format = {"***-***-", "+*-***-***-","+**-***-***-","+***-***-***-"};
            sb.append(format[s.length() % 10]);
            sb.append(s.substring(s.length() - 4));
        }
        return sb.toString();
    }
}