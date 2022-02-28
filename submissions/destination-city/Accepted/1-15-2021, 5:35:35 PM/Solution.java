// https://leetcode.com/problems/destination-city

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> city = new HashSet<>();
        for (List<String> path : paths) 
            city.add(path.get(0));
        for (List<String> path : paths) 
            if (!city.contains(path.get(1))) 
                return path.get(1);
            else city.remove(path.get(1));
        return "empty";
    }
}