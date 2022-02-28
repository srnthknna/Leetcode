// https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros

class Solution {
    public boolean checkZeroOnes(String s) {
        int longZ = 0, longO = 0, curZ = 0, curO = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                longZ = Math.max(longZ, ++curZ);
                curO = 0;
            } else {
                longO = Math.max(longO, ++curO);
                curZ = 0;
            }
        }
        return longO > longZ;
    }
}