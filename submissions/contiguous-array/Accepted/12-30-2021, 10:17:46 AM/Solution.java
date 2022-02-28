// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        int count = 0, maxLen = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (counts.containsKey(count)) {
                maxLen = Math.max(maxLen, i - counts.get(count));
            } else {
                counts.put(count, i);
            }
        }
        return maxLen;
    }
}