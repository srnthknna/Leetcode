// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int leftsum = 0, rightsum = 0;
        for (int i : nums)
            rightsum += i;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = (2 * i - nums.length) * nums[i] - leftsum + rightsum;
            leftsum += nums[i];
            rightsum -= nums[i];
        }
        return res;
    }
}