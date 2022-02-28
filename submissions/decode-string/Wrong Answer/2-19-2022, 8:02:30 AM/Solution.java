// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        Stack<String> chars = new Stack<>();
        String curr = "";
        String answer = "";
        int digit = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digit = digit * 10 + (c - '0');
            } else if (c == '[') {
                chars.push(Integer.toString(digit));
                chars.push(curr);
                digit = 0;
                curr = "";
            } else if (Character.isAlphabetic(c)) {
                curr += c;
            } else if (c == ']') {
                StringBuffer sb = new StringBuffer();
                
                String tempTopString = curr.equals("") ? answer + chars.pop() : chars.pop();
                int numberTop = Integer.parseInt(chars.pop());
                for (int i = 0; i < numberTop; i++) {
                    sb.append(curr);
                }
                answer += tempTopString + sb.toString();
                curr = "";
            }
        }
        return answer + curr;
    }
}