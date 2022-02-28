// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max= 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}