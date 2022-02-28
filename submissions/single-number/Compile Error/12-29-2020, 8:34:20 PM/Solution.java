// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int key : optimize) {
            if (map.get(key) == 1) return key;
        }
        return 0;
    }
}