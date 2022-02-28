// https://leetcode.com/problems/find-the-middle-index-in-array

class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0, leftsum = 0;
        for (int i : nums)
            total += i;
        //System.out.println(total);
        for (int i = 0; i < nums.length - 1; i++) {
            leftsum += nums[i];
            //System.out.println(leftsum + " " + (leftsum * 2) + " " + (total - nums[i + 1]));
            if (leftsum * 2 == total - nums[i + 1])
                return i + 1;
        }
        return nums.length == 1 ? 0 : -1;
    }
}