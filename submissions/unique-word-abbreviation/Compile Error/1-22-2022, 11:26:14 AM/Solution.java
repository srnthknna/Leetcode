// https://leetcode.com/problems/unique-word-abbreviation

class ValidWordAbbr {
    
    Map<String, Set<String>> abb;

    public ValidWordAbbr(String[] dictionary) {
        abb = new HashMap<>();
        for (String word : dictionary) {
            add(word, abbMaker(word));
        }
    }
    
    private String abbMaker(String word) {
        int len = word.legth();
        if (len <= 2) {
            return word;
        } 
        return new StringBuilder()
            .append(word.charAt(0))
            .append(len - 2)
            .append(word.charAt(len - 1))
            .toString();
    }
    
    private void add(String word, String abbr) {
        Set<String> words = abb.containsKey(abbr) ? abb.get(abbr) : new HashSet<>();
        words.add(word);
        abb.put(abbr, words);
    }
    
    public boolean isUnique(String word) {
        String currAbb = abbMaker(word);
        if (abb.containsKey(currAbb)) 
            return abb.get(currAbb).size() == 1 && abb.get(currAbb).contains(word);
        return true;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */