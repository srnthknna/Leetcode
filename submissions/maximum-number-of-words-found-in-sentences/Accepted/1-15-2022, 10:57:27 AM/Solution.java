// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences

class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences) {
            int count = 0;
            for (char c : sentence.toCharArray()) {
                if (c == ' ') {
                    count++;
                }
            }
            res = Math.max(res, count);
        }
        return res + 1;

        // return 1 + Arrays.stream(sentences).mapToInt(s -> (int)s.chars().filter(c -> c == ' ').count()).max().getAsInt();
    }
}