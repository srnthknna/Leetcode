// https://leetcode.com/problems/subdomain-visit-count

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        
        for (String cpdomain : cpdomains) {
            int spaceIndex = cpdomain.indexOf(" ");
            int hits = Integer.parseInt(cpdomain.substring(0, spaceIndex));
            String domain = cpdomain.substring(spaceIndex + 1);
            while (!domain.isEmpty()) {
                int dotIndex = domain.indexOf(".");
                counts.put(domain, counts.getOrDefault(domain, 0) + hits);
                if (dotIndex != -1) {
                    domain = domain.substring(dotIndex + 1);
                } else {
                    domain = "";
                }
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (String key : counts.keySet()) {
            ans.add(new StringBuilder().append(counts.get(key)).append(" ").append(key).toString());
        }
        return ans;
    }
}