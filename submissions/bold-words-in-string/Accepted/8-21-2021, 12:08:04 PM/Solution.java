// https://leetcode.com/problems/bold-words-in-string

class Solution {
    public String boldWords(String[] words, String s) {
        boolean[] arr = new boolean[s.length() + 1];
        
        for (int start = 0; start < s.length(); start++) {
            for (String word : words) {
                if (s.startsWith(word, start)) {
                    Arrays.fill(arr, start, start + word.length(), true);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0] ? "<b>" : "");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(s.charAt(i));
            if (!arr[i] && arr[i + 1]) sb.append("<b>");
            else if (arr[i] && !arr[i + 1]) sb.append("</b>");
        }
        return sb.toString();
    }
}