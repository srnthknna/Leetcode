// https://leetcode.com/problems/binary-search

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int pivot = l + (r - l) / 2;
            if (nums[pivot] == target) { 
                return pivot;
            } else if (target < nums[pivot]) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }
        return -1;
    }
}