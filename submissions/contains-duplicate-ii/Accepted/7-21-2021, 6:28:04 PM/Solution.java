// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if ((k==0) || (k>= 15000)) return false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}