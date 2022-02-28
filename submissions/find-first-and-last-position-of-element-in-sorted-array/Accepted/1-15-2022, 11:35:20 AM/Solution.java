// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findIndex(nums, target, true);
        result[1] = findIndex(nums, target, false);
        return result;
    }
    
    private int findIndex(int[] nums, int target, boolean isStart) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isStart) {
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}