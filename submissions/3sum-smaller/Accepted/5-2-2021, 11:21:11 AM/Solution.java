// https://leetcode.com/problems/3sum-smaller

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, target - nums[i], i + 1);
        }
        return sum;
    }
    private int twoSumSmaller(int[] nums, int target, int low) {
        int high = nums.length - 1;
        int sum = 0;
        while (low < high) {
            if (nums[low] + nums[high] < target) {
                sum += high - low;
                low++;
            } else {
                high--;
            }
        }
        return sum;
    }
}