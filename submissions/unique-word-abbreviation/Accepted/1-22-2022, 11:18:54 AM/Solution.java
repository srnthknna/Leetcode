// https://leetcode.com/problems/unique-word-abbreviation

class ValidWordAbbr {
    
    Map<String, Set<String>> abb;

    public ValidWordAbbr(String[] dictionary) {
        abb = new HashMap<>();
        for (String word : dictionary) {
            if (word.length() <= 2) {
                add(word, word);
            } else {
                add(word, "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1));
            }
        }
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
            String currAbb = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
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