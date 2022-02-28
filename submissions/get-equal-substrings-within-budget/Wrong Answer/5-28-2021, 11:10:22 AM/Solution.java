// https://leetcode.com/problems/get-equal-substrings-within-budget

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int length = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

                maxCost -= Math.abs(Math.abs((int )s.charAt(i) - (int) t.charAt(i)));
                //System.out.println(s.charAt(i) + " " + maxCost);
                length++;
                max = length;

            if (maxCost < 0) {
                maxCost += Math.abs(Math.abs((int )s.charAt(i) - (int) t.charAt(i)));
                start = i;
                max = Math.max(max, length - 1);
                length = 1;
            }
        }
        return max;
    }
}