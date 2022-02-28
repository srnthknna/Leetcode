// https://leetcode.com/problems/buddy-strings

class Solution {
    public boolean buddyStrings(String A, String B) {
        int[] count = new int[26];
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            for (Character c : A.toCharArray())
                count[c - 'a']++;
            for (int c : count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else return false;
                }
            }
            return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
        }
    }
}