// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int begin = 0, end = 0, len = Integer.MAX_VALUE, counter = map.size();
        String ans = "";
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) counter--;
            }
            end++;
            
            while (counter == 0) {
                if (end - begin < len) {
                    len = end - begin;
                    ans = s.substring(begin, end);
                }
                
                char startChar = s.charAt(begin);
                
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) counter++;
                }
                begin++;
            }
        }
        return ans;
    }
}