// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, longest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sum == k) {
                longest = i + 1;
            }
            
            if (map.containsKey(sum - k)) {
                longest = Math.max(longest, i - map.get(sum - k));
            } else {
                map.put(sum, i);
            }
        }
        return longest;
    }
}