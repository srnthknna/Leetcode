// https://leetcode.com/problems/arranging-coins

class Solution {
    public int arrangeCoins(int n) {
        int stairs = 0;
        while (n > 0 && n - (stairs + 1)  > 0) {
            stairs++;
            n = n - stairs;
        }
        return n - stairs == 1 ? stairs + 1 : stairs;
    }
}