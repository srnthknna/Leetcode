// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c , map.getOrDefault(c, 0) + 1);
        for (int i = 0; i < s.length() && map.containsKey(s.charAt(i); i++) 
            if (map.get(s.charAt(i)) == 1) return i;
            else map.remove(s.charAt(i));
        return -1;
    }
}