// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies

class Solution {
    // very similar to https://leetcode.com/problems/course-schedule/
    // Why do we use states instead of set =? good question the reason is to avoid cycles in the graph
    
    private static int NOT_VISITED = 0;
    private static int VISITING = 1;
    private static int VISITED = 2;
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> visited = new HashMap<>();
        for (String supply : supplies)
            visited.put(supply, VISITED);
        
        Map<String, List<String>> adj = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            visited.put(recipes[i], NOT_VISITED);
            adj.put(recipes[i], ingredients.get(i));
        }
        
        List<String> output = new ArrayList<>();
        for (String recipe : recipes) {
            dfs(recipe, adj, visited, output);
        }
        
        return output;
    }
    
    private boolean dfs(String recipe, Map<String, List<String>> adj, Map<String, Integer> visited, List<String> output) {
        if (!visited.containsKey(recipe)) return false;
        if (visited.get(recipe) == VISITING) return false;
        if (visited.get(recipe) == VISITED) return true;
        
        visited.put(recipe, VISITING);
        for (String ingridient : adj.get(recipe)) {
            if (!dfs(ingridient, adj, visited, output)) return false;
        }
        visited.put(recipe, VISITED);
        output.add(recipe);
        return true;
    }
}