// https://leetcode.com/problems/power-of-four

class Solution {
    public boolean isPowerOfFour(int n) {
        // if (n < 1) return false;
        // while (n % 4 == 0) {
        //     n /= 4;
        // }
        // return n == 1;
        return Math.log10(n) / Math.log10(4) % 1 == 0;
    }
}