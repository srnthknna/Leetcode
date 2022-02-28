// https://leetcode.com/problems/one-edit-distance

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        System.out.println("s " + s + " t " + t);
        if (ns > nt) {
            //swap
            String temp = s;
            s = t;
            t = temp;
            int tempint = ns;
            ns = nt;
            nt = tempint;
        }
        
        if (nt - ns > 1)
            return false;
        
                    System.out.println(ns + " " + nt);
            System.out.println(s + " "  + t);
        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (ns == nt)
                    return s.substring(i + 1).equals(t.substring( i + 1));
                else
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return (ns + 1 == nt);
    }
}