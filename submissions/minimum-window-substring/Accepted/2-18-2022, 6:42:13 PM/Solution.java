// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int begin = 0, end = 0;
        int counter = map.size();
        int len = Integer.MAX_VALUE;
        
        String ans = "";
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                
                if (map.get(endChar) == 0) {
                    counter--;
                }
            }
            
            end++;
            
            while(counter == 0) {
                // store new answer if smaller than previously best
                if(end - begin < len) {
                    len = end - begin;
                    ans = s.substring(begin, end); 
                }
                

                char startchar = s.charAt(begin);
                
                if(map.containsKey(startchar)) {
                   map.put(startchar, map.get(startchar) + 1);
                   if(map.get(startchar) > 0) counter++; 
                }
                
                begin++;
            }
            System.out.println(begin + " " + end);
        }
        return ans;
    }
}