// https://leetcode.com/problems/uncommon-words-from-two-sentences

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: s1.split(" "))
            map.put(word, map.getOrDefault(word, 0) + 1);
        for (String word: s2.split(" "))
            map.put(word, map.getOrDefault(word, 0) + 1);
        List<String> ans = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}