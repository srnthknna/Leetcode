// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapstot = new int[256];
        int[] mapttos = new int[256];
        Arrays.fill(mapstot, -1);
        Arrays.fill(mapttos, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int c1 = s.charAt(i);
            int c2 = t.charAt(i);
            
            if (mapstot[c1] == -1 && mapttos[c2] == -1) {
                mapstot[c1] = c2;
                mapttos[c2] = c1;
            }
            
            else if (!(mapstot[c1] == c2 && mapttos[c2] == c1))
                return false;
        }
        return true;
    }
}