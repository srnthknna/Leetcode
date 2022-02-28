// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        
        int counter = map.size(), begin = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        int wordSize = words[0].length(), len = wordSize * words.length;
        
        if (words.length == 0 || s.length() < len) return ans;
        
        for (int i = 0; i < wordSize; i++) {
            buildMap(words, map);
            counter = map.size();
            begin = i; end = i;
            
            while (end + wordSize - 1 < s.length()) {
                String endWord = s.substring(end, end + wordSize);
                
                if (map.containsKey(endWord)) {
                    map.put(endWord, map.get(endWord) - 1);
                    if (map.get(endWord) == 0) counter--;
                }
                
                if (end + wordSize - begin == len) {
                    if (counter == 0) {
                        ans.add(begin);
                    }
                    
                    String startWord = s.substring(begin, begin + wordSize);
                    
                    if (map.containsKey(startWord)) {
                        map.put(startWord, map.get(startWord) + 1);
                        if (map.get(startWord) > 0) counter++;
                    }
                    begin += wordSize;
                }
                end += wordSize;
            }
        }
        return ans;
    }
    
    private void buildMap(String[] words, Map<String, Integer> map) {
        map.clear();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
}