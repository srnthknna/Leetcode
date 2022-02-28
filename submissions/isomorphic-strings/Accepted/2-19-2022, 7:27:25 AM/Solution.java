// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        
        Map<Character, Character> fMap = new HashMap<>();
        Map<Character, Character> rMap = new HashMap<>();
        
        for (int i = 0; i < sLen; i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if (fMap.containsKey(sChar) && rMap.containsKey(tChar)) {
                if (fMap.get(sChar) != tChar && rMap.get(tChar) != sChar) return false;
                else continue;
            }
            if (fMap.containsKey(sChar) || rMap.containsKey(tChar)) {
                return false;
            }
            fMap.put(sChar, tChar);
            rMap.put(tChar, sChar);
        }
        return true;
    }
}