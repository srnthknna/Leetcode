// https://leetcode.com/problems/shuffle-the-array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length / 2; i++) {
            ret[2 * i] = nums[i];
            ret[2 * i + 1] = nums[i + 3];
        }
        return ret;
    }
}