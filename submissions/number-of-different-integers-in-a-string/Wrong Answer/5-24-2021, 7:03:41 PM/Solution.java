// https://leetcode.com/problems/number-of-different-integers-in-a-string

class Solution {
    public int numDifferentIntegers(String word) {
        int size = word.length();
        int i = 0;
        Set<String> set = new HashSet<>();
        while (i < size) {
            boolean isZeros = false;
            while (i < size && (Character.isAlphabetic(word.charAt(i)) || word.charAt(i) == '0')) {
                if (word.charAt(i) == '0') isZeros = true;
                ++i;
            }
            if (i < size && (Character.isDigit(word.charAt(i))) && word.charAt(i) != '0') {
                isZeros = false;
                StringBuilder sb = new StringBuilder();
                while (i < size && Character.isDigit(word.charAt(i))) {
                    sb.append(word.charAt(i));
                    i++;
                }
                set.add(sb.toString());
            } else if (isZeros) {
                set.add("0");
            }
        }
        return set.size();
    }
}