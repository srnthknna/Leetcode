// https://leetcode.com/problems/sentence-screen-fitting

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int pos = 0, len = s.length();
        
        for (int i = 0; i < rows; i++) {
            pos += cols;
            while (pos >= 0 && s.charAt(pos % len) != ' ') pos--;
            pos++;
        }
        return pos / len;
    }
}