// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        int left = 2, right = x / 2;
        if (x < 2) return x;
        long num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            num = (long) mid * mid;
            if (num == x) return mid;
            else if (num < x) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}