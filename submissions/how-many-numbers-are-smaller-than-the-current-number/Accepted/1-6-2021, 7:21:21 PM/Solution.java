// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[101];
        
        // number of occurance in the res array
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]]++;
        }
        // number of elements less than curr for all array
        for (int i = 1; i < 101; i++) {
            res[i] += res[i - 1];
        }
         // store the less than info from previous positions
        for (int i = 0; i < nums.length; i++) {
            int position = nums[i];
            if (position == 0) 
                nums[i] = 0;
            else 
                nums[i] = res[position - 1];
        }
        return nums;
    }
}