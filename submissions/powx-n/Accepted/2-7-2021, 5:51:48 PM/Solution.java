// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        int mid = n / 2;
        double powMid = myPow(x, mid);

        if (mid * 2 == n) {
            return powMid * powMid;
        } else {
            return powMid * powMid * myPow(x, n - mid * 2);
        }
    }
}