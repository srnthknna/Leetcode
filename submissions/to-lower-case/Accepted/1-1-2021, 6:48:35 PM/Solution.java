// https://leetcode.com/problems/to-lower-case

class Solution {
    public String toLowerCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((int) c | 32));
            } else result.append(c);
        }
        return result.toString();
    }
}