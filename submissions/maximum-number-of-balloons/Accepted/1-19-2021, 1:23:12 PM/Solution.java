// https://leetcode.com/problems/maximum-number-of-balloons

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[26];
        for (char c : text.toCharArray())
            map[c - 'a']++;
        char[] balloon = {'b','a','l','o','n'};
        int min = Integer.MAX_VALUE;
        for (char c : balloon) {
            int count = map[c - 'a'];
            if (c == 'l' || c == 'o') count /= 2;
            min = Math.min(count, min);
        }
        return min;
    }
}