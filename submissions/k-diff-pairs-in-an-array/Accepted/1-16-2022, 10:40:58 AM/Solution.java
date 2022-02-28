// https://leetcode.com/problems/k-diff-pairs-in-an-array

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int res = 0;
        for (int num : map.keySet()) {
            if (k > 0 && map.containsKey(num + k)) {
                res++;
            } else if (k == 0 && map.get(num) > 1) {
                res++;
            }
        }
        return res;
    }
}