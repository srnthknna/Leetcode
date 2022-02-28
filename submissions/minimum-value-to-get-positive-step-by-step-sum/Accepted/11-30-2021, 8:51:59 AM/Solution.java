// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum

class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0, minsum = 0;
        for (int i : nums) {
            sum += i;
            minsum = Math.min(minsum, sum);
        }
        return 1 - minsum;
    }
}