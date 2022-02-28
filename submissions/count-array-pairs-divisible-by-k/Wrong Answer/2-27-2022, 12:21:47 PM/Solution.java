// https://leetcode.com/problems/count-array-pairs-divisible-by-k

class Solution {
    public long countPairs(int[] nums, int k) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] * nums[j] % k == 0) 
                    count++;
            }
        }
        return count;
    }
}