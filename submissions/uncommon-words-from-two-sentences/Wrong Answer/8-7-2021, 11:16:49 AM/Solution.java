// https://leetcode.com/problems/uncommon-words-from-two-sentences

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> set = new HashSet<>();
        String[] words = s1.split(" ");
        for (String word : words) {
            if (set.contains(word))
                set.remove(word);
            else
                set.add(word);
        }
        words = s2.split(" ");
        for (String word : words) {
            if (set.contains(word))
                set.remove(word);
            else
                set.add(word);
        }
        String[] ans = new String[set.size()];
        int i = 0;
        for (String word : set) {
            ans[i++] = word;
        }
        return ans;
    }
}