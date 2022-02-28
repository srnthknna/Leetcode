// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxLength = 0, maxCount= 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            counts[s.charAt(windowEnd) - 'A']++;
            maxCount = Math.max(maxCount, counts[s.charAt(windowEnd) - 'A']);
            while (windowEnd - windowStart - maxCount + 1 > k) {
                counts[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }
}