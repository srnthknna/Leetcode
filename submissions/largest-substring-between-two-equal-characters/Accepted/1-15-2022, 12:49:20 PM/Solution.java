// https://leetcode.com/problems/largest-substring-between-two-equal-characters

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLen = -1;
        int[] index = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index[c - 'a'] > 0) {
                maxLen = Math.max(maxLen, i - index[c - 'a']);
            } else {
                index[c - 'a'] = i + 1;
            }
        }
        return maxLen;
    }
}