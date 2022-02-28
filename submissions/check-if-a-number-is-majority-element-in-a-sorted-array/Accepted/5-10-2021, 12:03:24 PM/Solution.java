// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int first = findFirst(nums, target);
        int plusIndex = first + nums.length / 2;
        return (plusIndex < nums.length && nums[plusIndex] == target);
    }
    
    private int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            if (nums[mid] >= target) high = mid;
        }
        return low;
    }
}