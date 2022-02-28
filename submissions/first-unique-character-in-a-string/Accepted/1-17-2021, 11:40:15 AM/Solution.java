// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int min = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int idx = s.indexOf(ch);
            if (idx != -1 && idx == s.lastIndexOf(ch)) min = Math.min(min, idx);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}