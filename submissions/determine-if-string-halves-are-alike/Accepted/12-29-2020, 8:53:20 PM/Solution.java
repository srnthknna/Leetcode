// https://leetcode.com/problems/determine-if-string-halves-are-alike

class Solution {
    public boolean halvesAreAlike(String s) {
        int countA = 0, countB = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                if (i < s.length() / 2) {
                    countA++;
                } else {
                    countB++;
                }
            }
        }
        return countA == countB;
    }
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c== 'i' || c == 'o' || c == 'u' ||
           c == 'A' || c == 'E' || c== 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }
}