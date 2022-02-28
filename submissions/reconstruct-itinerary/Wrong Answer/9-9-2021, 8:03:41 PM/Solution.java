// https://leetcode.com/problems/reconstruct-itinerary

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = createGraph(tickets);
        System.out.println(map);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add("JFK");
        
        List<String> output = new ArrayList<>();
        String prev = "JFK";
        String curr = "JFK";
        
        for (List<String> values : map.values()){
           Collections.sort(values); 
        }
        
        while (!queue.isEmpty()) {
            if (queue.size() > 0)
            curr = queue.remove();
            
            if (!visited.contains(prev + "->" + curr))
                visited.add(prev + "->" + curr);
            
            output.add(curr);
            prev = curr;
            
            System.out.println(prev + " " + curr);
            System.out.println("output " + output + " " + map);

            if (map.containsKey(prev)) {
                List<String> currNeigh = map.get(prev);
                if (currNeigh.size() > 0) {

                    for (String neigh : currNeigh) {
                        if (!map.containsKey(neigh) && currNeigh.size() > 1)
                            continue;
                        if (!visited.contains(prev + "->" + neigh)) {
                            queue.add(neigh);
                            map.get(prev).remove(neigh);
                            break;
                        }
                    }
                }  else {
                    map.remove(prev);
                }
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