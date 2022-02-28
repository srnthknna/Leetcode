// https://leetcode.com/problems/is-subsequence

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int tp = 0, sp = 0;
        while (tp < t.length()) {
            if (t.charAt(tp) == s.charAt(sp)) {
                sp++;
            }
            if (sp == s.length()) return true;
            tp++;
        }
        return false;
    }
}