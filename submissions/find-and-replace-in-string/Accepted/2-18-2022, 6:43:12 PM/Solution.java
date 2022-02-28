// https://leetcode.com/problems/find-and-replace-in-string

class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        
        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            if (s.substring(index, index + sources[i].length()).equals(sources[i]))
                match[index] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < n) {
            if (match[index] >= 0) {
                sb.append(targets[match[index]]);
                index += sources[match[index]].length();
            } else {
                sb.append(s.charAt(index++));
            }
        }
        return sb.toString();
    }
}