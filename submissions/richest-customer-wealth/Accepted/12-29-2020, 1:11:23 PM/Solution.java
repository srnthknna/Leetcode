// https://leetcode.com/problems/richest-customer-wealth

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] acc : accounts) {
            int sum = 0;
            for (int ac : acc) {
                sum += ac;
            }
            if (sum > max) {
                max =sum;
            }
        }
        return max;
    }
}