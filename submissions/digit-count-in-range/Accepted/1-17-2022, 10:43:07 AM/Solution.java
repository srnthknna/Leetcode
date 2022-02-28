// https://leetcode.com/problems/digit-count-in-range

class Solution {
    public int digitsCount(int d, int low, int high) {
        return count(d, high) - count(d, low - 1);
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