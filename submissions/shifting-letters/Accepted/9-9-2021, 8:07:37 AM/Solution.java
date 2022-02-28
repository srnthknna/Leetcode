// https://leetcode.com/problems/shifting-letters

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--)
            shifts[i] += shifts[i+1] % 26;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shifts.length; i++)
            sb.append((char)((s.charAt(i)-'a' + shifts[i]) % 26 + 'a'));
        return sb.toString();
    }
}