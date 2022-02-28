// https://leetcode.com/problems/second-largest-digit-in-a-string

class Solution {
    public int secondHighest(String s) {
        int max = -1, secMax = -1;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int c = ch - '0';
                if (c > max) {
                    secMax = max;
                    max = c;
                } else if (c > secMax && c < max) {
                    secMax = c;
                }
            }
        }
        
        return secMax;
    }
}