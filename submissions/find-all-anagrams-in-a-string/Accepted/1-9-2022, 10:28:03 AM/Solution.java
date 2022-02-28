// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int end = 0, begin = 0, len = p.length(), counter = map.size();
        List<Integer> ans = new ArrayList<>();
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) counter--;
            }
            
            end++;
            
            while (counter == 0) {
                if (end - begin == len) {
                    ans.add(begin);
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