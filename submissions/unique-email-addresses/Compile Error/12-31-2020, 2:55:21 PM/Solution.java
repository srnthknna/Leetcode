// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> em = new HashSet<>();
        StringBuilder sb;
        for (String s: emails) {
            sb = new StringBuilder();
            String[] eaddress = s.split("@");
            String[] newp = eaddress[0].split("\\+");
            sb.append([0].replaceAll("\\.", ""));
            sb.append("@");
            sb.append(eaddress[1]);
            em.add(sb.toString());
        }
        return em.size();
    }
}