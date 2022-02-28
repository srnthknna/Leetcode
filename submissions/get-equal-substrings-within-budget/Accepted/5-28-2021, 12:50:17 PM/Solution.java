// https://leetcode.com/problems/get-equal-substrings-within-budget

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0, result = 0, end;
        for (end = 0; end < s.length(); end++) {
            char charS = s.charAt(end), charT = t.charAt(end);
            if (charS != charT) {
                maxCost -= Math.abs(charS - charT);
            }

            while (maxCost < 0) {
                maxCost += Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            result = Math.max(end - start + 1, result);
        }
        return result;
    }
}