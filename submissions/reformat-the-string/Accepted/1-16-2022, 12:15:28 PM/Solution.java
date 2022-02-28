// https://leetcode.com/problems/reformat-the-string

class Solution {
    public String reformat(String s) {
        int ds = 0, as = 0;
        if (s == null || s.length() == 0) return "";
        
        for (char c : s.toCharArray())
            if (Character.isDigit(c)) ds++;
            else as++;
        
        if (Math.abs(as - ds) > 1) return "";
        
        StringBuilder sb = new StringBuilder();
        boolean isDigit = ds > as;
        for (int a = 0, d = 0, i = 0; i < s.length(); i++) {
            if (isDigit) {
                while (!Character.isDigit(s.charAt(d))) d++;
                sb.append(s.charAt(d++));
            } else {
                while (!Character.isLetter(s.charAt(a))) a++;
                sb.append(s.charAt(a++));
            }
            isDigit = !isDigit;
        }
        return sb.toString();
    }
}