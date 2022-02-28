// https://leetcode.com/problems/factorial-trailing-zeroes

class Solution {
    public int trailingZeroes(int n) {
        int zero = 0;
        while (n > 0) {
            n /= 5;
            zero += n;
        }
        return zero;
    }
}