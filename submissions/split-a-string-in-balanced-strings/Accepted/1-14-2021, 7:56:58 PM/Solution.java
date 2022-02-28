// https://leetcode.com/problems/split-a-string-in-balanced-strings

class Solution {
    public int balancedStringSplit(String s) {
        int l = 0, r = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                r++;
            } else {
                l++;
            }
            if (r == l) count++;
        }
        return count;
    }
}