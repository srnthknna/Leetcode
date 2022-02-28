// https://leetcode.com/problems/number-of-good-pairs

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        
        int sum = 0;
        for (int k : map.keySet()) {
            int val = map.get(k);
            if (val > 1) {
                sum += val * (val - 1) / 2;
            }
        }
        return sum;
    }
}