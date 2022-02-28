// https://leetcode.com/problems/sorting-the-sentence

class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String []ans = new String[words.length];
        for(String st: words){
            ans[st.charAt(st.length() - 1) - '1'] = st.substring(0, st.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length - 1; i++) {
            sb.append(ans[i]);
            sb.append(" ");
        }
        sb.append(ans[ans.length - 1]);
        return sb.toString();
    }
}