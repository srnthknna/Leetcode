// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> indices = new HashMap<>();
        int prefixSum = 0, longestSubarray = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            if (prefixSum == k) {
                longestSubarray = i + 1;
            }
            
            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
            }
            
            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }
        return longestSubarray;
    }
}