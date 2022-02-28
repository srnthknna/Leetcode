// https://leetcode.com/problems/number-of-digit-one

class Solution {
    public int countDigitOne(int n) {
        return digitCount(1, n, 0);
    }
    
    private int digitCount(int digit, int high, int low) {
        return count(digit, high) - count(digit, low - 1);
    }
    
    private int count(int digit, int val) {
        int ans = 0;
        for (int t = 1; t <= val; t *= 10) {
            int left = val / t, right = val % t;
            ans += (left - digit + 9) / 10 * t + (left % 10 == digit ? 1 + right : 0);
            if (digit == 0) {
                ans -= t;
            }
        }
        return ans;
    }
}