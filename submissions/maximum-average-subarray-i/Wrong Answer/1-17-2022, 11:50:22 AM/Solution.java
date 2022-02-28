// https://leetcode.com/problems/maximum-average-subarray-i

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        for (int i = k ; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }
}