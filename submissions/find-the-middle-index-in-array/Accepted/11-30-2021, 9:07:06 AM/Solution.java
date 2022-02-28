// https://leetcode.com/problems/find-the-middle-index-in-array

class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int leftsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftsum == sum - nums[i])
                return i;
            leftsum += nums[i];
        }
        return -1;
    }
}