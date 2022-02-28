// https://leetcode.com/problems/subdomain-visit-count

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        
        for (String cpdomain : cpdomains) {
            int hits = Integer.parseInt(cpdomain.substring(0, cpdomain.indexOf(" ")));
            String domain = cpdomain.substring(cpdomain.indexOf(" ") + 1);
            while (!domain.isEmpty()) {
                counts.put(domain, counts.getOrDefault(domain, 0) + hits);
                if (domain.indexOf(".") != -1) {
                    domain = domain.substring(domain.indexOf(".") + 1);
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