// https://leetcode.com/problems/excel-sheet-column-title

class Solution {
    public String convertToTitle(int n) {
        //return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + n % 26);
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n % 26;
            if (remainder == 0)
                remainder += 26; // 'Z'
            if (n >= remainder) {
                n -= remainder;
                sb.append((char) (remainder + 'A' - 1));
            }
            n /= 26;
        }
        return sb.reverse().toString();
    }
}