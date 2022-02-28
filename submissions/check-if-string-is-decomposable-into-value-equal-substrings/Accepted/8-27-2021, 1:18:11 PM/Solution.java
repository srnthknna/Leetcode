// https://leetcode.com/problems/check-if-string-is-decomposable-into-value-equal-substrings

class Solution {
    public boolean isDecomposable(String s) {
        int[] counts = new int[10];
        int twocount = 0;
        
        for (int i = 0; i < s.length(); i++)
            counts[s.charAt(i) - '0']++;
        
        for (int count : counts) {
            count = count % 3;
            if (count == 1) return false;
            twocount += count == 2 ? 1 : 0;
        }
        return twocount == 1;
    }
}