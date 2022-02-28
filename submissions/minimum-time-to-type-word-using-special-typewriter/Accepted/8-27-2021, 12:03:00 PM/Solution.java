// https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter

class Solution {
    public int minTimeToType(String word) {
        int result = word.length();
        
        result += Math.min(Math.abs(word.charAt(0) - 'a'), 26 - Math.abs(word.charAt(0) - 'a'));
        
        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);
            char prev = word.charAt(i - 1);
            result += Math.min(Math.abs(current - prev), 26 - Math.abs(current - prev));
        }
        return result;
    }
}