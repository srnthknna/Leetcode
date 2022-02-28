// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : time) {
            int mod = t % 60;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        
        int count = map.getOrDefault(0, 0) * (map.getOrDefault(0, 0) - 1)/2;
        count += map.getOrDefault(30, 0) * (map.getOrDefault(30, 0) - 1) / 2;
        for (int i = 1; i <= 29; i++) {
            count += map.getOrDefault(i, 0) * map.getOrDefault(60 - i, 0);
        }
        return count;
    }
}