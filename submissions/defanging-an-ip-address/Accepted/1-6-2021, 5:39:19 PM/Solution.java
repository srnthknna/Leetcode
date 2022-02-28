// https://leetcode.com/problems/defanging-an-ip-address

class Solution {
    public String defangIPaddr(String address) {
        // StringBuilder sb = new StringBuilder();
        // for (char c : address.toCharArray()) {
        //     if (c == '.') {
        //         sb.append("[.]");
        //     } else sb.append(c);
        // }
        // return sb.toString();
        return address.replaceAll("\\.", "[.]");
    }
}