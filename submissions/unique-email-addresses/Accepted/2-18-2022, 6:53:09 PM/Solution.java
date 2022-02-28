// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> em = new HashSet<>();
        for (String s: emails) {
            String[] eaddress = s.split("@");
            String[] newp = eaddress[0].split("\\+");
            em.add(newp[0].replaceAll("\\.", "") + "@" + eaddress[1]);
        }
        return em.size();
    }
}