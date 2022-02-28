// https://leetcode.com/problems/long-pressed-name

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) return true;
        
        if (name.length() > typed.length()) return false;
        
        int i = 0, j = 0;
        
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                while (j + 1 < typed.length() && name.charAt(i) == typed.charAt(j + 1)) {
                    j++;
                                    System.out.println ("wi " + i + " j " + j);
                }
                i++;
                System.out.println ("i " + i + " j " + j);
            } else {
                return false;
            }
        }
        return i == name.length() && j == typed.length();
    }
}