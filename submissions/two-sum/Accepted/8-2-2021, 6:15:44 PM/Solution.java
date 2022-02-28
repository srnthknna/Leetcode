// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (a.containsKey(target - nums[i])) {
                return new int[]{a.get(target - nums[i]), i};
            }
            a.put(nums[i], i);
        }
        return null;
    }
}