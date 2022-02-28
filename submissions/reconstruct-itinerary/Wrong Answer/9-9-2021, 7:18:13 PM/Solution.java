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
        while (!queue.isEmpty() || !map.isEmpty() && prev != curr) {
            if (queue.size() > 0)
            curr = queue.remove();
            
            if (!visited.contains(prev + "->" + curr))
                visited.add(prev + "->" + curr);
            
            output.add(curr);
            if (map.containsKey(curr))
                prev = curr;
            else
                curr = prev;
            
            //System.out.println(prev + " " + curr);
            if (map.containsKey(prev) && map.get(prev).contains(curr))
                map.get(prev).remove(curr);
            //System.out.println("output " + output);

            if (map.containsKey(curr)) {
                List<String> currNeigh = map.get(curr);
                if (currNeigh.size() > 0) {
                    Collections.sort(currNeigh, Comparator.reverseOrder());

                    if (!visited.contains(curr + "->" + currNeigh.get(0))) {
                        queue.add(currNeigh.get(0));
                        map.get(curr).remove(currNeigh.get(0));
                    }
                }
            } else {
                //System.out.println(map);
                map.remove(curr);
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