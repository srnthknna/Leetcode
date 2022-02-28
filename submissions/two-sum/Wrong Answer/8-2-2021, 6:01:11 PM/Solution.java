// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) 
            map.put(nums[i], i);
        
        for (int num : nums) {
            if (map.containsKey(num) && map.containsKey(target - num)) {
                ans[0] = map.get(num);
                ans[1] = map.get(target - num);
            }
                
        }
        return ans;
    }
}