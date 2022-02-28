// https://leetcode.com/problems/shortest-completing-word

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] c = new int[26];
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch))
                c[ch - 'a']++;
        }
        Arrays.sort(words, (String a, String b) -> a.length() - b.length());
        for (String word : words) {
            if (helper(c.clone(), word))
                return word;
        }
        return "";
    }
    
    private boolean helper(int[] c, String word) {
        for (char ch : word.toLowerCase().toCharArray())
            if (Character.isLetter(ch))
                c[ch - 'a']--;
        for (int l : c)
            if (l > 0)
                return false;
        return true;
    }
}