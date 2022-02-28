// https://leetcode.com/problems/calculate-money-in-leetcode-bank

class Solution {
    public int totalMoney(int n) {
        int res = 0, tmp = 0;
        for (int i = 0; n / 7 > i; i++)
            res += 28 + tmp++ * 7;
        for (int i = 0; i < n % 7 ; i++)
            res += tmp + 1 + i;
        return res;
    }
}