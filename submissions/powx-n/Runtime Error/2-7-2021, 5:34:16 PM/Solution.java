// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return x;
        if (n < 0) {
            x = 1 / x;
            n = -1 * n;
        }
        
        if (n % 2 == 1) return x * myPow(x * x, n / 2);
        else return myPow(x * x, n / 2);
    }
}