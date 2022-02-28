// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] c = new int[26];
        for (char ch : magazine.toCharArray())
            c[ch - 'a']++;
        for (char ch : ransomNote.toCharArray())
            c[ch - 'a']--;
        for (int i : c)
            if (i < 0)
                return false;
        return true;
    }
}