// https://leetcode.com/problems/get-equal-substrings-within-budget

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                maxCost -= Math.abs(Math.abs((int )s.charAt(i) - (int) t.charAt(i)));
            }

            if (maxCost < 0) {
                maxCost += Math.abs(Math.abs((int )s.charAt(start) - (int) t.charAt(start)));
                start++;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}