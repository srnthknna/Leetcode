// https://leetcode.com/problems/maximum-subarray-sum-after-one-operation

class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int sum = 0, curr = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            curr = Math.max(num * num, Math.max(curr + num, sum + num * num));
            sum = Math.max(num, sum + num);
            max = Math.max(curr, max);
        }
        return max;
    }
}