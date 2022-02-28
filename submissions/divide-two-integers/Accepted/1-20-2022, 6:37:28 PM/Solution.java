// https://leetcode.com/problems/divide-two-integers

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        boolean isNegative = (dividend >= 0) == (divisor >= 0) ? false : true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int result = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                // System.out.println("divisor " + divisor);
                // System.out.println((1 << count) + " " + (divisor << count));
                // System.out.println((divisor << 1 << count));
                count++;
            }
            result += (1 << count);
            dividend -= (divisor << count);
        }
        return isNegative ? -result : result;
    }
}