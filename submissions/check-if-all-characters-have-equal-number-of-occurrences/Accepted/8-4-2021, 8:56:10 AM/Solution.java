// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int prev = map[s.charAt(0) - 'a'];
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0 && map[i] != prev) return false;
        }
        return true;
    }
}