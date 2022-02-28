// https://leetcode.com/problems/most-common-word

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("(!|\\?|'|,|;|\\.)", " ");
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for (String word : banned)
            set.add(word);
        
        int max = 0; 
        String maxWord = null;
        for (String word : words) {
            String current = word.toLowerCase();
            if (!set.contains(current)) {
                map.put(current, map.getOrDefault(current, 0) + 1);
                if (map.get(current) > max) {
                    max = map.get(current);
                    maxWord = current;
                }
            }
        }
        return maxWord;
    }
}