// https://leetcode.com/problems/find-the-middle-index-in-array

class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0, leftsum = 0;
        for (int i : nums)
            total += i;
        for (int i = 0; i < nums.length; leftsum += nums[i++]) {
            if (leftsum * 2 == total - nums[i])
                return i;
        }
        return -1;
    }
}