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
        if (word.length() <= 2) {
            return word;
        } 
        return new StringBuilder().append(word.charAt(0))
            .append((word.length() - 2))
            .append(word.charAt(word.length() - 1))
            .toString();
    }
    
    private void add(String word, String abbr) {
        if (abb.containsKey(abbr)) {
            if (!abb.get(abbr).contains(word)) {
                abb.get(abbr).add(word);
            }
        } else {
            Set<String> words = new HashSet<>();
            words.add(word);
            abb.put(abbr, words);
        }
    }
    
    public boolean isUnique(String word) {
        if (word.length() <= 2) return true;
        else {
            String currAbb = abbMaker(word);
            if (abb.containsKey(currAbb)) return abb.get(currAbb).size() == 1 && abb.get(currAbb).contains(word);
        }
        return true;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */