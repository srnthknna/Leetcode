// https://leetcode.com/problems/n-repeated-element-in-size-2n-array

class Solution {
    public int repeatedNTimes(int[] nums) {
        for (int k = 1; k <= 3; k++) {
            for (int i = 0; i < nums.length - k; i++)
                if (nums[i] == nums[i + k])
                    return nums[i];
        }
        throw null;
    }
}