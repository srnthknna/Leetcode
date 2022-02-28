// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii

class Solution {
    public String removeDuplicates(String s, int k) {
        String temp = "", curr = s;
        while (!temp.equals(curr)) {
            temp = curr;
            curr = removeDuplicates(k, curr);
            //System.out.println("curr " + curr);
            //System.out.println("temp " + temp);
        }
        return curr;
    }
    
    public String removeDuplicates(int k, String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0, lastCounter = k;
        int ind = 0;
        for (char c : S.toCharArray()) {
            //System.out.println((ind++) + " starting " + c + " " + sb.toString());
            if (sbLength != 0 && c == sb.charAt(sbLength - 1)) {
                //System.out.println("sbLength " + sb.toString() + " " + lastCounter);
                if (lastCounter < k) {
                    //System.out.println("Fist in if " + lastCounter);
                    sb.append(c);
                    sbLength++;
                    lastCounter--;
                } 
                if (lastCounter == 0) {
                    //System.out.println("here its 0 " + sb.toString());
                    for (int i = 0; i < k; i++) {
                        sb.deleteCharAt(sbLength - 1);
                        sbLength--;
                    }
                    //System.out.println("after delete " + sb.toString());
                }
            } else {
                //System.out.println("entering for default append");
                sb.append(c);
                sbLength++;
                lastCounter = k - 1;
            }
        }
        return sb.toString();
    }
}