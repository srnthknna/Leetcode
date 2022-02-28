// https://leetcode.com/problems/calculate-money-in-leetcode-bank

class Solution {
    public int totalMoney(int n) {
        if (n == 0) return 0;
        int start = 1, sum = 0, week = 1;
        for (int i = 0; i < n; i++) {
            sum += week;
            week++;
            if (i + 1 % 7 == 0) {
                start++;
                week = start;
            }
        }
        return sum;
    }
}