// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0, min = 0, res = 0;
        for (int num : nums) {
            max = Math.max(0, max + num);
            min = Math.min(0, min + num);
            res = Math.max(res, Math.max(max, -min));
        }
        return res;
    }
}