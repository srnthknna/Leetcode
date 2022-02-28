// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram

class Solution {
    public int minSteps(String s, String t) {
        int[] counts = new int[26];
        for (Character c : s.toCharArray()) counts[c - 'a']++;
        for (Character c : t.toCharArray()) if (counts[c - 'a'] > 0) counts[c - 'a']--;
        int sum = 0;
        for (int i : counts) sum = sum + i;
        return sum;
    }
}