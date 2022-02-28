// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array

class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            if (sb.length() >= s.length()) break;
            sb.append(word);
        }
        
        return sb.toString().equals(s);
    }
}