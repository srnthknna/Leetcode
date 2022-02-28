// https://leetcode.com/problems/accounts-merge

class Solution {
    // https://www.youtube.com/watch?v=J5YnIxbG3hw
    // DFS with union find
    // How is this union find? the g we build undirected graph between the email connections
    // Then we do a dfs to combile all the emails that are associated
    // We sort the emails associated for order
    // Then just add the name in front to make them accepted in the solution
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> g = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        buildGraph(g, accounts, emailToName);
        
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        
        for (String mail : emailToName.keySet()) {
            
            if (visited.add(mail)) {
                List<String> list = new ArrayList<>();
                list.add(mail);
                dfs(list, visited, g, mail);
                Collections.sort(list);
                list.add(0, emailToName.get(mail));
                result.add(list);
            }
        }
        return result;
    }
    
    private void buildGraph(Map<String, Set<String>> g, List<List<String>> accounts, Map<String, String> emailToName) {
        for (List<String> a: accounts) {
            String name = a.get(0);
            
            for (int i = 1; i < a.size(); i++) {
                String mail = a.get(i);
                emailToName.put(mail, name);
                g.putIfAbsent(mail, new HashSet<>());
                if (i == 1) continue;
                String prev = a.get(i - 1);
                g.get(mail).add(prev);
                g.get(prev).add(mail);
            }
        }
    }
    
    private void dfs(List<String> list, Set<String> visited, Map<String, Set<String>> g, String mail) {
        if (g.get(mail) == null || g.get(mail).size() == 0) return;
        
        for (String neigh : g.get(mail)) {
            if (visited.add(neigh)) {
                list.add(neigh);
                dfs(list, visited, g, neigh);
            }
        }
    }
}