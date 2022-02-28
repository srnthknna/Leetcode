// https://leetcode.com/problems/evaluate-division

class Solution {
    
    class Equation {
        String denom;
        double val;
        
        public Equation(String denom, double val) {
            this.denom = denom;
            this.val = val;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Equation>> graph = buildGraph(equations, values);
        
        double[] result = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++)
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        
        return result;
    }
    
    private double dfs(String num, String denom, Set<String> visited, Map<String, List<Equation>> graph) {
        if (!graph.containsKey(num) || !graph.containsKey(denom)) 
            return -1.0;
        if (num.equals(denom)) 
            return 1.0;
        visited.add(num);
        
        for (Equation eq : graph.get(num)) {
            if (!visited.contains(eq.denom)) {
                double ans = dfs(eq.denom, denom, visited, graph);
                if (ans != -1.0)
                    return ans * eq.val;
            }
        }
        return -1.0;
    }
    
    private Map<String, List<Equation>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Equation>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String num = equations.get(i).get(0);
            String denom = equations.get(i).get(1);
            
            graph.putIfAbsent(num, new ArrayList<>());
            graph.putIfAbsent(denom, new ArrayList<>());
            
            graph.get(num).add(new Equation(denom, values[i]));
            graph.get(denom).add(new Equation(num, 1 / values[i]));
        }
        return graph;
    }
}