// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        int single = 123123;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == single) {
                single = 123123;
            } else if (single == 123123) {
                single = nums[i] ;
            }
        }
        return single;
    }
}