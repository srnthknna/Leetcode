// https://leetcode.com/problems/long-pressed-name

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) return true;
        
        if (name.length() > typed.length()) return false;
        
        int i = 0, j = 0;
        
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                while (j < typed.length() && name.charAt(i) == typed.charAt(j)) {
                    j++;
                    if (i + 1 < name.length() && name.charAt(i + 1) == typed.charAt(j)) i++;
                }
                i++;
            } else {
                return false;
            }
        }
        return i == name.length() && j == typed.length();
    }
}