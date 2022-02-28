// https://leetcode.com/problems/degree-of-an-array

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> nums_map = new HashMap<>();
        int degree = 0;
        Map<Integer, Integer> first_seen = new HashMap<>();
        int minLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            first_seen.putIfAbsent(nums[i], i);
            nums_map.put(nums[i], nums_map.getOrDefault(nums[i], 0) + 1);
            if (nums_map.get(nums[i]) > degree) {
                degree = nums_map.get(nums[i]);
                minLength = i - first_seen.get(nums[i]) + 1;
            } else if (degree == nums_map.get(nums[i])) {
                minLength = Math.min(minLength, i - first_seen.get(nums[i]) + 1);
            }
        }
        return minLength;
    }
}