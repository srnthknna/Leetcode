// https://leetcode.com/problems/largest-unique-number

class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        int max = -1;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                max = Math.max(max, key);
            }
        }
        return max;
    }
}