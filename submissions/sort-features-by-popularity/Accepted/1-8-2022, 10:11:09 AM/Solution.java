// https://leetcode.com/problems/sort-features-by-popularity

class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> counts = new HashMap<>();
        for (String feature : features) {
            counts.put(feature, 0);
        }
        
        for (String response : responses) {
            Set<String> wordSet = new HashSet<>(Arrays.asList(response.split(" ")));
            for (String word : wordSet) {
                if (counts.containsKey(word))
                    counts.put(word, counts.get(word) + 1);
            }
        }
        
        Arrays.sort(features, (feature1, feature2) -> (counts.get(feature2) - counts.get(feature1)));
        
        return features;
    }
}