// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = k; i < nums.length; i++)
            res = Math.min(res, nums[i] - nums[i - k]);
        return res;
    }
}