// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] *= -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        return nums;
    }
}