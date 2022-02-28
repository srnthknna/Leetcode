// https://leetcode.com/problems/remove-all-occurrences-of-a-substring

class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length(), m = part.length();
        
        if (n < m) return s;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= m) {
                String temp = "";
                for (int j = m - 1; j >= 0; j--) {
                    if (part.charAt(j) == stack.peek()) {
                        temp = stack.pop() + temp;
                    } else {
                        for (char t : temp.toCharArray()) {
                            stack.push(t);
                        } 
                        break;
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (char t : stack) {
            result.append(t);
        }
        return result.toString();
    }
}