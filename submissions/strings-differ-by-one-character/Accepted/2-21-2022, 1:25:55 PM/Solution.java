// https://leetcode.com/problems/strings-differ-by-one-character

class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String word : dict) {
            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < sb.length(); i++) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, '*');
                String currWord = sb.toString();
                if (set.contains(currWord)) return true;
                set.add(currWord);
                sb.setCharAt(i, temp);
            }
        }
        return false;
    }
}