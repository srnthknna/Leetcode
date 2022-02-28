// https://leetcode.com/problems/shuffle-the-array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ret = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                ret[i] = nums[i / 2];
            } else {
                ret[i] = nums[n + i / 2];
            }
        }
        return ret;
    }
}