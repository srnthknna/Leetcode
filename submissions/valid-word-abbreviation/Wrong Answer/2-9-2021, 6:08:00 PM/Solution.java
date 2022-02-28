// https://leetcode.com/problems/valid-word-abbreviation

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() > word.length()) return false;
        int i = 0, j = 0;
        for (; i < abbr.length(); i++) {
            int digit = 0;
            if (Character.isDigit(abbr.charAt(i))) {
                while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                    digit = digit * 10 + (abbr.charAt(i) - '0');
                    i++;
                }
                i--;
                j += digit;
                if (j > word.length()) return false;
            } else if ( i < abbr.length() && j < word.length() && abbr.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            }
        }
        System.out.println(j);
        return j == word.length();
    }
}