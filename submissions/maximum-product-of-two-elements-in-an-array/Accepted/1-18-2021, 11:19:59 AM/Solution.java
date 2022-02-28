// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array

class Solution {
    public int maxProduct(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int smax = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (max < nums[i]) {
                smax = max;
                max = nums[i];
            } else if (smax < nums[i]) {
                smax = nums[i];
            }
        }
        return (max - 1) * (smax - 1);
    }
}