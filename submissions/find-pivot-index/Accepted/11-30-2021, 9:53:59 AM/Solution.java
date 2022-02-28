// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int i : nums)
            sum += i;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftsum == sum - nums[i])
                return i;
            leftsum += nums[i];
        }
        return -1;
    }
}