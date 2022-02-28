// https://leetcode.com/problems/valid-word-abbreviation

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        for (int i = 0, j = 0; i < abbr.length(); i++) {
            int digit = 0;
            if (Character.isDigit(abbr.charAt(i))) {
                while (Character.isDigit(abbr.charAt(i))) {
                    digit = digit * 10 + (abbr.charAt(i) - 48);
                    i++;
                }
                i--;
                j += digit;
            } else if ( i < abbr.length() && j < word.length() && abbr.charAt(i) == word.charAt(j)) {
                j++;
            } else return false;
        }
        return true;
    }
}