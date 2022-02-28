// https://leetcode.com/problems/get-equal-substrings-within-budget

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0, result = 0, end;
        for (end = 0; end < s.length(); end++) {
            if (s.charAt(end) != t.charAt(end)) {
                maxCost -= Math.abs(Math.abs(s.charAt(end) - t.charAt(end)));
            }

            if (maxCost < 0) {
                maxCost += Math.abs(Math.abs(s.charAt(start) - t.charAt(start)));
                start++;
            }
        }
        return end - start;
    }
}