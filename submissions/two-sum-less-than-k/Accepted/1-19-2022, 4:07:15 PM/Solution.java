// https://leetcode.com/problems/two-sum-less-than-k

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                ans = Math.max(ans, sum);
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}