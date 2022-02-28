// https://leetcode.com/problems/rearrange-spaces-between-words

class Solution {
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        String copy = text;
        String[] words = copy.trim().split(" +");
        int count = 0, distribute = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') count++;
        }
        if ((words.length - 1) > 0) {
            distribute = count / (words.length - 1);
            for (int j = 0; j < words.length - 1; j++) {
                sb.append(words[j]);
                for (int i = 0; i < distribute; i++) {
                    sb.append(' ');
                }
                count -= distribute;
            }
        }
        sb.append(words[words.length - 1]);
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}