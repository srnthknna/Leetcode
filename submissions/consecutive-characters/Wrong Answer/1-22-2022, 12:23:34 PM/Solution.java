// https://leetcode.com/problems/consecutive-characters

class Solution {
    public int maxPower(String s) {
        int max = 0, curr = 0;
        if (s == null || s.length() == 0) return max;
        
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                curr++;
                max = Math.max(max, curr);
            } else {
                curr = 1;
                prev = s.charAt(i);
            }
        }
        return max;
    }
}