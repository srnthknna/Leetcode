// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] ret = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[r] > Math.abs(nums[l])) {
                ret[i] = nums[r] * nums[r];
                r--;
            } else {
                ret[i] = nums[l] * nums[l];
                l++;
            }
        }
        return ret;
    }
}