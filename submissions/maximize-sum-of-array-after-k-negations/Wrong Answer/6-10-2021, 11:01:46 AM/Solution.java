// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0) {
                k--;
                sum += -1 * nums[i];
            } else {
                sum += nums[i];
            }
        }
        return sum;
    }
}