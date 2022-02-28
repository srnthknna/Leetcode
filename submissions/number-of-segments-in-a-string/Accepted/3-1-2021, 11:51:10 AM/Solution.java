// https://leetcode.com/problems/number-of-segments-in-a-string

class Solution {
    public int countSegments(String s) {
        s = s.trim();
        int count = 0;
        if (s.isEmpty()) return 0;
        if (s.length() < 1) return 1; 
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                count++;
            }
        }
        return ++count;
    }
}