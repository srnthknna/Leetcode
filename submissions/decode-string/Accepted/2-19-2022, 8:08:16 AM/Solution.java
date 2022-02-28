// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack();
        Stack<StringBuilder> strings = new Stack();
        StringBuilder cstring = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = 10 * k + (c - '0');
            } else if (c == '[') {
                count.push(k);
                strings.push(cstring);
                k = 0;
                cstring = new StringBuilder();
            } else if (c == ']') {
                StringBuilder decoded = strings.pop();
                for (int i = count.pop(); i > 0; i--) {
                    decoded.append(cstring);
                }
                cstring = decoded;
            } else {
                cstring.append(c);
            }
        }
        return cstring.toString();
    }
}