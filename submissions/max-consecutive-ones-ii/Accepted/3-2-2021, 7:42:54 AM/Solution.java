// https://leetcode.com/problems/max-consecutive-ones-ii

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int k = 1, left = 0, right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;
            if (k < 0) {
                if (nums[left] == 0) k++;
                left++;
            }
        }
        return right - left;
    }
}