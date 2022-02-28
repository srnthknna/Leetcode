// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, count = 0;;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                count = 0;
            } else if (nums[i] == nums[j] && count < 1) {
                nums[++i] = nums[j];
                count++;
            }
        }
        return ++i;
    }
}