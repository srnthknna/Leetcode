// https://leetcode.com/problems/occurrences-after-bigram

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second))
                result.add(words[i]);
        }
        String[] returnWords = new String[result.size()];
        int i = 0;
        for (String word : result)
            returnWords[i++] = word;
        return returnWords;
    }
}