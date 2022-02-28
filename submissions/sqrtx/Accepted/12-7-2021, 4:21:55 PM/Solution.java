// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        // If below 2 return directly as the sqrt is either 0 or 1
        if (x < 2) return x;
        // start with 2 and till half of the number
        int left = 2, right = x / 2;

        long num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // to accomodate overflow we need to take in long
            num = (long) mid * mid;
            
            if (num == x) return mid;
            else if (num < x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}