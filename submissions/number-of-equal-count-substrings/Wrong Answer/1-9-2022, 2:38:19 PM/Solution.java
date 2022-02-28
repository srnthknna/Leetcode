// https://leetcode.com/problems/number-of-equal-count-substrings

class Solution {
    public int equalCountSubstrings(String s, int count) {
        Map<Character, Integer> map = new HashMap<>();
        
        int begin = 0, end = 0, counter = 0, ans = 0;;
        
        while (end < s.length()) {
            char curr = s.charAt(end);
            
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if (map.get(curr) == count) counter++;
            
            end++;
            
            while ((end - begin) == counter * count) {
                if ((end - begin) == counter * count) {
                    //System.out.println(map);
                    ans++;
                }
                
                char startChar = s.charAt(begin);
                
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) - 1);
                    if (map.get(startChar) == 0) counter--;
                }
                begin++;
            }
            //System.out.println(begin + " " + end);
        }
        return ans == 0 ? ans : ans - 1;
    }
}