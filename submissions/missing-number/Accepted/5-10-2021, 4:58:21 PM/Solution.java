// https://leetcode.com/problems/missing-number

class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int expectedSum = length * (length + 1) / 2;   
        for (int num : nums) expectedSum -= num;
        return expectedSum;
    }
}