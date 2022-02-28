// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int i = -1, j = -1, k = -1;
        for (int num : nums) {
            if (num == 0) {
                nums[++k] = 2;
                nums[++j] = 1;
                nums[++i] = 0;
            } else if (num == 1) {
                nums[++k] = 2;
                nums[++j] = 1;
            } else if (num == 2) {
                nums[++k] = 2;
            }
        }
    }
}