// https://leetcode.com/problems/find-the-highest-altitude

class Solution {
    public int largestAltitude(int[] gain) {
        int[] calc = new int[gain.length + 1];
        calc[0] = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            calc[i + 1] = gain[i] + calc[i];
            max = Math.max(calc[i + 1], max);
        }
        return max;
    }
}