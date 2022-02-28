// https://leetcode.com/problems/truncate-sentence

class Solution {
    public String truncateSentence(String s, int k) {
        int idx = 0;
        int space = 0;
        while (idx < s.length() && space < k) {
            if (s.charAt(idx) == ' ') space++;
            idx++;
        }
        return space != k ? s : s.substring(0, idx - 1);
    }
}