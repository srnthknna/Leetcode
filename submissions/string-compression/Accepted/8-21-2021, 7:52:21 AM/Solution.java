// https://leetcode.com/problems/string-compression

class Solution {
    public int compress(char[] chars) {
        int index = 0, indexAns = 0;
        while (index < chars.length) {
            int count = 0;
            char cur = chars[index];
            while (index < chars.length && chars[index] == cur) {
                index++;
                count++;
            }
            chars[indexAns++] = cur;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }
}