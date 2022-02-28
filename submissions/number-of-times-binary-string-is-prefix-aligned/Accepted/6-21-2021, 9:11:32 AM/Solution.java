// https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned

class Solution {
    public int numTimesAllBlue(int[] light) {
        int ans = 0, sumInd = 0, sumVal = 0;
        for (int i = 0; i < light.length; i++) {
            sumInd += i;
            sumVal += light[i] -1;
            if (sumInd == sumVal) ans++;
        }
        return ans;
    }
}