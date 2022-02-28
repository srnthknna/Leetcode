// https://leetcode.com/problems/check-if-the-sentence-is-pangram

class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] set = new int[26];
        for (char c : sentence.toCharArray())
            set[c - 'a'] = 1;
        for (int c : set) {
            if (c == 0) return false;
        }
        return true;
    }
}