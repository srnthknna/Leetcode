// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int pivot = l + (r - l) / 2;
            if (nums[pivot] < target) {
                l = pivot + 1;
            } else if (nums[pivot] > target) {
                r = pivot - 1;
            } else {
                return pivot;
            }
        }
        return l;
    }
}