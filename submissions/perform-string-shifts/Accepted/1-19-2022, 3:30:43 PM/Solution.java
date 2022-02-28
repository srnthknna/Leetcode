// https://leetcode.com/problems/perform-string-shifts

class Solution {
    public String stringShift(String s, int[][] shifts) {
        int leftshifts = 0;
        for (int[] shift: shifts) {
            if (shift[0] == 1) {
                shift[1] = -shift[1];
            }
            leftshifts += shift[1];
        }
        leftshifts = Math.floorMod(leftshifts, s.length());
        s = s.substring(leftshifts) + s.substring(0, leftshifts);
        return s;
    }
}