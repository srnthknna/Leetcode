// https://leetcode.com/problems/remove-all-occurrences-of-a-substring

class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length(), m = part.length();
        
        if (n < m) return s;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= m) {
                StringBuilder temp = new StringBuilder();
                for (int j = m - 1; j >= 0; j--) {
                    if (part.charAt(j) == stack.peek()) {
                        temp.insert(0, stack.pop());
                    } else {
                        for (char t : temp.toString().toCharArray()) {
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