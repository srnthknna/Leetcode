// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int begin = 0, end = 0, len = 0, counter = 0;;
        Map<Character, Integer> map = new HashMap<>();
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            
            map.put(endChar, map.getOrDefault(endChar , 0) + 1);
            if (map.get(endChar) == 1) counter++;
            
            end++;
            
            while (counter > k) {
                char startChar = s.charAt(begin);
                
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) - 1);
                    if (map.get(startChar) == 0) counter--;
                }
                
                begin++;
            }
            len = Math.max(len, end - begin);
        }
        return len;
    }
}