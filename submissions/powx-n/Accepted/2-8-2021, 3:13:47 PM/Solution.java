// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        if (n == 0) return 1;
        
        int mid = n / 2;
        double powMid = myPow(x, mid);
        powMid *= powMid;
        if (2 * mid == n) {
            // n is even
            return powMid;
        } else {
            return powMid * myPow(x, n - 2 * mid);
        }
    }
}