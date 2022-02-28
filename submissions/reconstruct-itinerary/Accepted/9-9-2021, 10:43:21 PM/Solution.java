// https://leetcode.com/problems/reconstruct-itinerary

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = createGraph(tickets);
        
        Stack<String> stack = new Stack<>();
        stack.add("JFK");
        
        List<String> output = new ArrayList<>();
        
        for (List<String> values : map.values()){
           Collections.sort(values); 
        }
        
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if (map.containsKey(curr) && map.get(curr).size() != 0) {
                String node = map.get(curr).get(0);
                stack.add(node);
                map.get(curr).remove(node);
            } else {
                output.add(0, curr);
                stack.pop();
            }      
        }
        return output;         
    }
    
    private Map<String, List<String>> createGraph(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (List<String> toAndFro : tickets) {
            map.putIfAbsent(toAndFro.get(0), new ArrayList<String>());
            map.get(toAndFro.get(0)).add(toAndFro.get(1));
        }
        return map;
    }
}