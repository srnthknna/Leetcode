// https://leetcode.com/problems/number-of-different-integers-in-a-string

class Solution {
    public int numDifferentIntegers(String word) {
        int size = word.length();
        int i = 0;
        Set<String> set = new HashSet<>();
        while (i < size) {
            while ( i < size && Character.isAlphabetic(word.charAt(i)) || word.charAt(i) == '0') i++;
            if (Character.isDigit(word.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                while (i < size && Character.isDigit(word.charAt(i))) {
                    sb.append(word.charAt(i));
                    i++;
                }
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}