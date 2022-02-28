// https://leetcode.com/problems/reverse-only-letters

class Solution {
    public String reverseOnlyLetters(String S) {
        int j = S.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                sb.append(S.charAt(j));
                j--;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}