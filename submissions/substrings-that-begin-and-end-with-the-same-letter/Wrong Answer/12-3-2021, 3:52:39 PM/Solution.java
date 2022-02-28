// https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter

class Solution {
    public long numberOfSubstrings(String s) {
        int[] letter = new int[26];
        //int result2 = 0;
        for (char c : s.toCharArray()) {
            ++letter[c - 'a'];
            //result2 += ++letter[c - 'a'];
        }
        int result = 0;
        for (int i : letter) {
            if (i != 0) {
                result += (i) * (i + 1) / 2;
            }
        }
        return result;
    }
}