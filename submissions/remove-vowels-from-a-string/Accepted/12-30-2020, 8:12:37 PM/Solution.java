// https://leetcode.com/problems/remove-vowels-from-a-string

class Solution {
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (!isVowel(c)) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
           c =='A' || c == 'E' || c == 'I'  || c == 'O' || c == 'U';
    }
}