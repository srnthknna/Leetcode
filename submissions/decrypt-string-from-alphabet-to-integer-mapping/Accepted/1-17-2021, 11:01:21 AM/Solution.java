// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping

class Solution {
    public String freqAlphabets(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') + 96));
                i += 3;
            } else {
                sb.append((char) (s.charAt(i) - '0' + 96));
                i++;
            }
        }
        return sb.toString();
    }
}