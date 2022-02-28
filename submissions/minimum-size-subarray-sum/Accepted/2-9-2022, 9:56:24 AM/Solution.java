// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    // Sliding window
    // https://www.youtube.com/watch?v=jKF9AcyBZ6E&list=WL&index=6&ab_channel=NickWhite
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, valSum = 0, result = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            valSum += nums[i];
            while (valSum >= target) {
                result = Math.min(result, i + 1 - left);
                valSum -= nums[left++];
            }
        }
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}