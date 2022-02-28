// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            for (int j = 1, count = 1; j <= s.length(); j++) {
                if (j == s.length() || s.charAt(j - 1) != s.charAt(j)) {
                    next.append(count);
                    next.append(s.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            s = next.toString();
        }
        return s;
    }
}