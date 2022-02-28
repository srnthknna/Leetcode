// https://leetcode.com/problems/shuffle-string

class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        
        char[] c = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            c[indices[i]] = s.charAt(i);
        }
        
        for (char v : c) {
            sb.append(v);
        }
        
        return sb.toString();
    }
}