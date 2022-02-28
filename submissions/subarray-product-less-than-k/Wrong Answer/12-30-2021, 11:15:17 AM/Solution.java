// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1, ans = 0, left = 0, right = 0;
        for (;right < nums.length; right++) {
            prod *= nums[right];
            if (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}