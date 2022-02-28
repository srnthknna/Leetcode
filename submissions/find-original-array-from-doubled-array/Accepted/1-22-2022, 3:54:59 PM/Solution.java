// https://leetcode.com/problems/find-original-array-from-doubled-array

class Solution {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        if (changed.length % 2 == 1) return new int[0];
        
        int result[] = new int[changed.length / 2], i = 0;
        
        for (int val : changed)
            map.put(val, map.getOrDefault(val, 0) + 1);
        
        for (int x : map.keySet()) {
            if (map.get(x) > map.getOrDefault(x + x, 0)) return new int[0];
            for (int ind = 0; ind < map.get(x); ind++) {
                result[i++] = x;
                map.put(x + x, map.get(x + x) - 1);
            }
        }
        return result;
    }
}