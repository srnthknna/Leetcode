// https://leetcode.com/problems/calculate-money-in-leetcode-bank

class Solution {
    public int totalMoney(int n) {
        if (n == 0) return 0;
        int start = 1, sum = 0, week = 1;
        for (int i = 1; i <= n; i++) {
            sum += week++;
            if (i % 7 == 0) {
                start++;
                week = start;
            }
        }
        return sum;
    }
}