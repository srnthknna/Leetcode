// https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter

class Solution {
    public long numberOfSubstrings(String s) {
        int[] letter = new int[26];
        long result2 = 0;
        for (char c : s.toCharArray()) {
            result2 += ++letter[c - 'a'];
        }
        return result2;
    }
}