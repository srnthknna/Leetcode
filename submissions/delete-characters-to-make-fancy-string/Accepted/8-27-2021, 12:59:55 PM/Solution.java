// https://leetcode.com/problems/delete-characters-to-make-fancy-string

class Solution {
    public String makeFancyString(String s) {
        if (s.length() <= 2) return s;
        
        char one = s.charAt(0);
        char two = s.charAt(1);
        StringBuilder sb = new StringBuilder();
        sb.append(one).append(two);
        
        for (int i = 2; i < s.length(); i++) {
            if (one == two && two == s.charAt(i))
                continue;
            else {
                one = two;
                two = s.charAt(i);
                sb.append(two);
            }   
        }
        return sb.toString();
    }
}