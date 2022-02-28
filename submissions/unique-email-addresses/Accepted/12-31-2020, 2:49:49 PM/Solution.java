// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> em = new HashSet<>();
        for (String s: emails) {
            String[] eaddress = s.split("@");
            em.add(eaddress[0].replaceAll("(\\+\\S*)|\\.", "")+ "@" + eaddress[1]);
        }
        return em.size();
    }
}