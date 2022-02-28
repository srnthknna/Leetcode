// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sums = new HashMap<>();
        int count = 0, sum = 0;
        sums.put(sum, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sums.containsKey(sum - k)) {
                count += sums.get(sum - k);
            }
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}