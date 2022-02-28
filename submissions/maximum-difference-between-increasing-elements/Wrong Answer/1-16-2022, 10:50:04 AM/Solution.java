// https://leetcode.com/problems/maximum-difference-between-increasing-elements

class Solution {
    public int maximumDifference(int[] nums) {
        int res = -1, min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return res;
    }
}