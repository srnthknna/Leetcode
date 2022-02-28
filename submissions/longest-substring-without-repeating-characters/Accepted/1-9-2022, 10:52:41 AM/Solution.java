// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, len = 0;
        
        while (end < s.length()) {
            char curr = s.charAt(end);
            
            if (map.containsKey(curr) && map.get(curr) >= begin) {
                begin = map.get(curr) + 1;
            } else {
                map.put(curr, end);
                end++;
            }
            
            if (end - begin > len) {
                len = end - begin;
            }
        }
        return len;
    }
}