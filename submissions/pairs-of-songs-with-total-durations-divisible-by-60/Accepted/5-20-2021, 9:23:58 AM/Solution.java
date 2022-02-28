// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 60; i++)
            map.put(i, 0);
        for (int t : time) {
            map.put(t % 60, map.get(t % 60) + 1);
        }
        
        int count = map.get(0) * (map.get(0) - 1)/2;
        count += map.get(30) * (map.get(30) - 1) / 2;
        for (int i = 1; i <= 29; i++) {
            count += map.get(i) * map.get(60 - i);
        }
        return count;
    }
}