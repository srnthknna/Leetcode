// https://leetcode.com/problems/single-row-keyboard

class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] map = new int[26];
        int index = 0, steps = 0;
        for (char c : keyboard.toCharArray()) map[c -'a'] = index++;
        steps += map[word.charAt(0) - 'a'];
        for (int i = 1; i < word.length(); i++) {
            steps += Math.abs(map[word.charAt(i - 1) - 'a'] - map[word.charAt(i) - 'a']);
        }
        return steps;
    }
}