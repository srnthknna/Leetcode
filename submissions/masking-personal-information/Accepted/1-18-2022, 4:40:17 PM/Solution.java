// https://leetcode.com/problems/masking-personal-information

class Solution {
    String[] country = {"", "+*-", "+**-", "+***-"};
    public String maskPII(String s) {
        int index = s.indexOf("@");
        if (index > 0) {
            s = s.toLowerCase();
            return s.substring(0, 1) + "*****" + s.substring(index - 1);
        }
        s = s.replaceAll("[^0-9]", "");
        return country[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
    }
}