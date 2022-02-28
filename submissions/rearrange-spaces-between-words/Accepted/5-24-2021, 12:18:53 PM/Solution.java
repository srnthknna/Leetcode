// https://leetcode.com/problems/rearrange-spaces-between-words

class Solution {
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        List<String> actualWords = new ArrayList<>();
        String[] words = text.split(" ");
        for(String word: words){
            if(!word.trim().equals(""))
                actualWords.add(word.trim());
        }
        int count = 0, distribute = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') count++;
        }
        if ((actualWords.size() - 1) > 0) {
            distribute = count / (actualWords.size() - 1);
            for (int j = 0; j < actualWords.size() - 1; j++) {
                sb.append(actualWords.get(j));
                for (int i = 0; i < distribute; i++) {
                    sb.append(' ');
                }
                count -= distribute;
            }
        }
        sb.append(actualWords.get(actualWords.size() - 1));
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}