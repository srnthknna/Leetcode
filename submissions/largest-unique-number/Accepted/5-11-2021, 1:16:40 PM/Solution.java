// https://leetcode.com/problems/largest-unique-number

class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey());
            }
        }
        return max;
    }
}