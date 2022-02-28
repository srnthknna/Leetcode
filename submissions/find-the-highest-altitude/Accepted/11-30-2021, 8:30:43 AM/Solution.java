// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0, current = 0;
        for (int i = 0; i < gain.length; i++) {
            current += gain[i];
            max = Math.max(max, current);
        }
        return max;
    }
}