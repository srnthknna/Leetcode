// https://leetcode.com/problems/single-row-keyboard

class Solution {
    public int calculateTime(String keyboard, String word) {
        int index = 0;
        Map<Character, Integer> keys = new HashMap<>();
        for (char c : keyboard.toCharArray()) {
            keys.put(c, index++);
        }
        
        int curr = 0, ans = 0;
        for (char c : word.toCharArray()) {
            int currVal = keys.get(c);
            ans += Math.abs(curr - currVal);
            curr = currVal;
        }
        return ans;
    }
}