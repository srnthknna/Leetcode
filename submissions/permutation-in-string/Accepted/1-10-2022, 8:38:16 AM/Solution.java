// https://leetcode.com/problems/permutation-in-string

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size(), len = s1.length(), begin = 0, end = 0;
        
        while (end < s2.length()) {
            char endChar = s2.charAt(end);
            
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) counter--;
            }
            
            end++;
            
            while (counter == 0) {
                if (end - begin == len) return true;
                
                char startChar = s2.charAt(begin);
                
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) == 1) counter++; 
                }
                begin++;
            }
        }
        return false;
    }
}