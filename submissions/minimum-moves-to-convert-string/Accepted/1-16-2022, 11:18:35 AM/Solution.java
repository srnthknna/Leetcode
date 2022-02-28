// https://leetcode.com/problems/minimum-moves-to-convert-string

class Solution {
    public int minimumMoves(String s) {
        int res = 0, i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'O')
                i++;
            else {
                res++; i += 3;
            }
        }
        return res;
    }
}