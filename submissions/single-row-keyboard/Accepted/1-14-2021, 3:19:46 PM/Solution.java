// https://leetcode.com/problems/single-row-keyboard

class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0, steps = 0;
        for (char c : keyboard.toCharArray()) map.put(c, index++);
        if (word.length() == 0) return steps;
        steps += map.get(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            steps += Math.abs(map.get(word.charAt(i - 1)) - map.get(word.charAt(i)));
        }
        return steps;
    }
}