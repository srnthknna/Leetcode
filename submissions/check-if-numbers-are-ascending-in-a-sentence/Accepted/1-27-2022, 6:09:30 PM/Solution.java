// https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence

class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = 0, cur = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch))
                cur = cur * 10 + (ch - '0');
            else if (cur != 0) {
                if (prev >= cur)
                    return false;
                prev = cur;
                cur = 0;
            }
        }
        return cur == 0 || prev < cur;
    }
}