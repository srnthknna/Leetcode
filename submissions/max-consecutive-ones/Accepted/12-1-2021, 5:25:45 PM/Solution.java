// https://leetcode.com/problems/max-consecutive-ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0, max = 0;
        for (int i : nums) {
            if (i == 0) {
                curr = 0;
            } else {
                curr++;
                max = Math.max(curr, max);
            }
        }
        return max;
    }
}