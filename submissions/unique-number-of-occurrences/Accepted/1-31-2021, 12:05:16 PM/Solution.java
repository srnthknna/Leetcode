// https://leetcode.com/problems/unique-number-of-occurrences

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> values = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int val : map.values())
            if (!values.add(val))
                return false;
        return true;
    }
}