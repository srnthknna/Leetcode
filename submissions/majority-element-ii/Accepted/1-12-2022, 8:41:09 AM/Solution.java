// https://leetcode.com/problems/majority-element-ii

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<Integer> ans = new ArrayList<>();
        for (int num: map.keySet()) {
            if (map.get(num) > nums.length / 3) {
                ans.add(num);
            }
        }
        return ans;
    }
}