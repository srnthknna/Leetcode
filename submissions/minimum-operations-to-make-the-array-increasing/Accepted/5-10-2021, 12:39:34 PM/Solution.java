// https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing

class Solution {
    public int minOperations(int[] nums) {
        int minOperation = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[ i - 1]) continue;
            int difference = nums[i - 1] - nums[i] + 1; 
            minOperation += difference;
            nums[i] += difference;
        }
        return minOperation;
    }
}