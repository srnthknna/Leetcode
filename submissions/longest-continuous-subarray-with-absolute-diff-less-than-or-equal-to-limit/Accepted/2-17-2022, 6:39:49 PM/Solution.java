// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0, r = 0, maxLength = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (r < nums.length) {
            addWindow(map, nums[r++]);
            while (Math.abs(map.firstKey() - map.lastKey()) > limit) {
                removeWindow(map, nums[l++]);
            }
            maxLength = Math.max(maxLength, r - l);
        }
        return maxLength;
    }
    
    private void addWindow(Map<Integer, Integer> map, int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    
    private void removeWindow(Map<Integer, Integer> map, int num) {
        int occurance = map.get(num);
        if (occurance == 1) {
            map.remove(num);
        } else {
            map.put(num, occurance - 1);
        }
    }
}