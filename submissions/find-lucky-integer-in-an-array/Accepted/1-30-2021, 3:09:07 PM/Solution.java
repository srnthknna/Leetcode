// https://leetcode.com/problems/find-lucky-integer-in-an-array

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                result = Math.max(result, entry.getValue());
            }
        }
        return result;
    }
}