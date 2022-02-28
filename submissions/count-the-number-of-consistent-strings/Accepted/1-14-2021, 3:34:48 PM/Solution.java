// https://leetcode.com/problems/count-the-number-of-consistent-strings

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) set.add(c);
        int result = 0;
        for (String word : words) {
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    valid = false;
                    break;
                }
            }
            if (valid) result++;
        }
        return result;
    }
}