// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters

class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, ans = 0;
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) + 1);
            } else {
                map.put(endChar, 1);
            }
            
            if (map.get(endChar) == 1) 
                counter++;

            end++;
            
            while (counter == 3) {
                char startChar = s.charAt(begin);
                
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) - 1);
                    if (map.get(startChar) == 0) counter--;
                }
                begin++;
            }
            ans += begin;
        }
        return ans;
    }
}